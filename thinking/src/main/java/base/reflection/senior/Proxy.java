package base.reflection.senior;

/*
 * on 2019/3/19
 * By SIGMOD3
 * */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface Seller {
    void sell();
}

public class Proxy {
    public static void main(String[] args) {
        Seller seller = new CarSeller();
        System.out.println("不使用代理：");
        seller.sell();
        System.out.println("使用代理方式：");
        ClassLoader loader = Seller.class.getClassLoader();
        //the method has expired since jdk9.0
        //seller = (Seller) Proxy.newProxyInstance(loader, new Class[]{Seller.class}, new Agency());
        seller.sell();
    }
}

class CarSeller implements Seller {
    public void sell() {
        System.out.println("销售人员在卖车");
    }
}

class Agency implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理人员在卖车");
        return null;
    }
}
