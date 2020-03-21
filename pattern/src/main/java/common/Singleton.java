package common;

/**
 * 饿汉式静态常量，线程安全，容易造成内存浪费，不推荐
 *
 * @author minqian
 */
public class Singleton {
    private final static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstanc() {
        return instance;
    }

    /**
     * 饿汉式静态代码块，同上
     */
    static class Singleton2 {
        private static Singleton2 instance;

        static {
            instance = new Singleton2();
        }

        private Singleton2() {
        }

        public static Singleton2 getInstance() {
            return instance;
        }
    }

    /**
     * 懒汉式同步，效率很低，不推荐
     */
    static class Singleton3 {
        private static Singleton3 instance;

        private Singleton3() {
        }

        //垃圾代码--在只需执行一次的代码位置加锁
        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }
            return instance;
        }
    }

    /****************************************************************
     ************************以下为推荐使用****************************
     ****************************************************************/

    /**
     * 双重检查，延迟加载
     */
    static class Singleton4 {
        private static volatile Singleton4 instance;

        private Singleton4() {
        }

        public static Singleton4 getInstance() {
            if (instance == null) {
                synchronized (Singleton4.class) {
                    if (instance == null) {
                        instance = new Singleton4();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 静态内部类实现，延迟加载
     */
    static class Singleton5 {
        private Singleton5() {
        }

        private static class SingletonInstance {
            private static final Singleton5 instance = new Singleton5();
        }

        public static Singleton5 getInstance() {
            return SingletonInstance.instance;
        }
    }
}