package thinking.tclass;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

/**
 * @author: minqian
 * @since: 2020/7/9
 * @description:
 */
public class BaseSean {

    public static void main(String[] args) {
        enumTest();
        stackTest();
        hashTableTest();
    }

    /**
     * 包含了一种类似C++的向量类型
     */
    public static void enumTest() {
        Enumeration<String> enumeration;
        Vector<String> names = new Vector<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        enumeration = names.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    /**
     * 简单栈
     */
    public static void stackTest() {
        Stack<String> stack = new Stack<>();
        if (stack.empty()) {
            stack.push("a");
            stack.push("b");
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * hash表哦
     */
    public static void hashTableTest() {
        Hashtable<String, Object> names = new Hashtable<>();
        names.put("a", 1);
        names.put("b", 2);
        names.put("c", 3);
        System.out.println(names.get("b"));
        names.clear();
        System.out.println(names.isEmpty());
    }
}
