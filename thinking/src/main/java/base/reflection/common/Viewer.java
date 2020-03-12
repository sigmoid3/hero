package base.reflection.common;

/*
 * on 2019/3/19
 * By SIGMOD3
 * */
import java.util.*;
public class Viewer {
    private String id;
    private String name;
    //this is a ps
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = new Date().getClass();
        System.out.println(c1.getName());
        Class c2 = boolean.class;
        System.out.println(c2.getName());
        Class c3 = Class.forName("java.lang.String");
        System.out.println(c3.getName());
        Class c4 = Double.TYPE;
        System.out.println(c4.getName());
        Viewer v = new Viewer();
        System.out.println(v.getClass().getName());
    }
    public Viewer(){
        System.out.println("init...");
    }
}
