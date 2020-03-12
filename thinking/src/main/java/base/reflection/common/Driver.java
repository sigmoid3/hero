package base.reflection.common;

/*
 * on 2019/3/19
 * By SIGMOD3
 * */

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Driver {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> viewer = Class.forName("com.sandro.base.reflection.common.Viewer");
        //输出相关类的注释，不包括所有注释
        System.out.println("输出相关类的注释，不包括所有注释");
        Annotation[] annotations = viewer.getAnnotations();
        if (annotations.length != 0) {
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
        } else {
            System.out.println("空");
        }

        //输出类的泛型参数
        System.out.println("输出类的泛型参数");
        TypeVariable<?>[] typeVariables = viewer.getTypeParameters();
        if (typeVariables.length != 0) {
            for (TypeVariable<?> typeVariable : typeVariables) {
                System.out.println(typeVariable);
            }
        } else {
            System.out.println("空");
        }

        //输出类所实现的所有接口
        System.out.println("输出类所实现的所有接口");
        Type[] interfaces = viewer.getGenericInterfaces();
        if (interfaces.length != 0) {
            for (Type type : interfaces) {
                System.out.println(type);
            }
        } else {
            System.out.println("空");
        }

        //输出类的直接继承类
        System.out.println("输出类的直接继承类");
        Type superClass = viewer.getGenericSuperclass();
        if (superClass != null) {
            System.out.println(superClass);
        } else {
            System.out.println("空");
        }

        //输出类的构造方法
        System.out.println("输出类的构造方法");
        Constructor[] constructors = viewer.getConstructors();
        if (constructors.length != 0) {
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }
        } else {
            System.out.println("空");
        }

        //输出类对象所有非继承域
        System.out.println("输出类对象所有非继承域");
        Field[] fields = viewer.getDeclaredFields();
        if (fields.length != 0) {
            for (Field field : fields) {
                System.out.println(field);
            }
        } else {
            System.out.println("空");
        }

        //输出类对象所有非继承方法
        System.out.println("输出类对象所有非继承方法");
        Method[] methods = viewer.getMethods();
        if (methods.length != 0) {
            for (Method method : methods) {
                System.out.println(method);
            }
        } else {
            System.out.println("空");
        }
        //private域可以通过Class运行时使用反射机制获取操作权限，id.setAccessible(true)
    }
}
