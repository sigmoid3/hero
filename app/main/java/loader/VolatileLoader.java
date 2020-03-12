package loader;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VolatileLoader {

    public static class VolatileVisible implements Runnable {
        volatile boolean running = true;  //对比一下有无volatile的情况下，整个程序运行结果的区别

        void m() {
            System.out.println("m start");
            while (running) {  //死循环。只有running=false时，才能执行后面的语句

            }
            System.out.println("m end");
        }

        @Override
        public void run() {
            VolatileVisible vt = new VolatileVisible();
            new Thread(vt::m, "t1").start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            vt.running = false;  //若running不被volatile关键字修饰时，线程“看不见”running被修改了
        }
    }

    public static class VolatileNoAtomic implements Runnable {
        volatile int count = 0;

        void m() {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

        @Override
        public void run() {
            VolatileNoAtomic vna = new VolatileNoAtomic();
            List<Thread> threads = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                threads.add(new Thread(vna::m, "thread" + i));
            }
            threads.forEach(o -> o.start());
            threads.forEach((o) -> {
                try {
                    o.join(); //相当于在主线程中同步o线程，o执行完了，main线程才有执行的机会
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(vna.count);
        }
    }

    /**
     * 给list添加volatile之后，t2能够接到通知，但t2线程的死循环很浪费CPU
     */
    public static class MyContainerVolatile implements Runnable {
        volatile List list = new ArrayList();

        public void add(Object o) {  //add
            list.add(o);
        }

        public int size() {   //size
            return list.size();
        }

        @Override
        public void run() {
            MyContainerVolatile mcv = new MyContainerVolatile();
            new Thread(() -> {  //该线程负责往list里添加
                for (int i = 0; i < 10; i++) {
                    mcv.add(new Object());
                    System.out.print(" add-" + i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "t1").start();
            new Thread(() -> { //该线程一直监测list的size，直到size=5
                while (true) {  //一直监测着，很浪费CPU
                    if (mcv.size() == 5) {  //此处未加同步，仍然可能会出现t1中又一次++为6了，才break
                        break;
                    }
                }
                System.out.print(" t2结束 ");
            }, "t2").start();
        }
    }

    /**
     * wait会释放锁，notify则不会。t1中notify唤醒t2，本线程不会释放锁，会一直执行下去直至被wait或synchronized代码块结束
     */
    public static class MyContainerWaitNotify implements Runnable {
        volatile List list = new ArrayList();

        public void add(Object o) {
            list.add(o);
        }

        public int size() {
            return list.size();
        }

        @Override
        public void run() {
            MyContainerWaitNotify mcwn = new MyContainerWaitNotify();
            final Object lock = new Object();
            new Thread(() -> {
                synchronized (lock) {
                    System.out.print(" ***线程t2启动*** ");
                    if (mcwn.size() != 5) {
                        try {
                            lock.wait();  //size不等于5时，就一直在那等着，直到被t1叫醒
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print(" ***线程t2结束*** ");
                    lock.notify();  //通知t1继续执行
                }
            }, "t2").start();
            new Thread(() -> {
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        mcwn.add(new Object());
                        System.out.print(" add-" + i);
                        if (mcwn.size() == 5) {
                            lock.notify();  //唤醒另一个线程t2，本线程继续执行，直至synchronized包裹的代码块结束或者调用了wait
                            try {
                                lock.wait(); //释放锁，让t2得以执行
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "t1").start();
        }
    }

    public static class MyContainerLatch implements Runnable {
        volatile List list = new ArrayList(); //添加volatile，使t2能够得到通知

        public void add(Object o) {
            list.add(o);
        }

        public int size() {
            return list.size();
        }

        @Override
        public void run() {
            MyContainerLatch mcl = new MyContainerLatch();
            CountDownLatch latch = new CountDownLatch(1);  //当1变成0时，门就开了
            new Thread(() -> {
                System.out.print(" *t2启动* ");
                if (mcl.size() != 5) {
                    try {
                        latch.await(5000, TimeUnit.MILLISECONDS);  //等待不需要锁定一个对象
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(" *t2结束* ");
            }, "t2").start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(() -> {
                System.out.print(" *t1启动* ");
                for (int i = 0; i < 10; i++) {
                    mcl.add(new Object());
                    System.out.print(" add-" + i);
                    if (mcl.size() == 5) {
                        latch.countDown(); //打开门闩，让t2得以执行。调用一次countDown，就减1
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(" *t1结束* ");
            }, "t1").start();
        }
    }
}