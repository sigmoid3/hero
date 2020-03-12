package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Sandro
 * @Create: 2019-06-02 20:25
 * @Info:
 **/
public class ProxyHandler implements InvocationHandler {
    private Object sar;

    //绑定委托对象，返回代理类
    Object bind(Object sar) {
        this.sar = sar;
        //绑定实现接口,代理类实现参数（代理加载类的对象，给代理类提供的接口，关联的InvocationHandler对象）
        return Proxy.newProxyInstance(sar.getClass().getClassLoader(), sar.getClass().getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        //进行aop编程
        //在调用具体函数前，执行功能处理
        result = method.invoke(sar, args);
        //在调用具体函数方法后，执行功能处理
        return result;
    }
}
