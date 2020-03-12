package base.reflection.senior;
/*
 * on 2019/3/19
 * By SIGMOD3
 * */

import java.lang.reflect.*;
import java.util.Arrays;

public class Dynamic {
    public static void main(String[] args) {
        dynamicInovke();
        int[] intArray = new int[10];
        System.out.println(intArray.length);
        Arrays.fill(intArray, 8);
        System.out.println(Arrays.toString(intArray));
        int[] newArray = (int[]) DynamicArray.increaseArray(intArray);
        System.out.println(newArray.length);
        System.out.println(Arrays.toString(newArray));
        Dynamic dy = new Dynamic();
        System.out.println(StringUtils.toString(dy));
    }

    public static void dynamicInovke() {
        try {
            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE);
            Double sin1 = (Double) sin.invoke(null, new Integer(1));
            System.out.println(sin1);
            Method equals = String.class.getDeclaredMethod("equals", Object.class);
            Boolean mrsoft = (Boolean) equals.invoke(new String("易发"), "易发");
            System.out.println(mrsoft);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Class.newInstance()和Constructor.newInstance()都可以不new获取对象，前者只能调用无参构造方法，后者可以调用有参构造方法
}

//next,实现一个动态数组
class DynamicArray {
    public static Object increaseArray(Object array) {
        Class<?> clazz = array.getClass();
        if (clazz.isArray()) {
            Class<?> componentType = clazz.getComponentType();
            int length = Array.getLength(array);
            Object newArray = Array.newInstance(componentType, length * 2);
            System.arraycopy(array, 0, newArray, 0, length);
            return newArray;
        }
        return null;
    }
}

class StringUtils {
    @SuppressWarnings("unchecked")
    public static String toString(Object object) {
        Class clazz = object.getClass();
        StringBuilder sb = new StringBuilder();
        Package packageName = clazz.getPackage();
        sb.append("包名：" + packageName.getName() + "\t");
        String className = clazz.getSimpleName();
        sb.append("类名：" + className + "\t");
        sb.append("公共构造方法：\n");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            String modifier = Modifier.toString(constructor.getModifiers());
            if (modifier.contains("public")) {
                sb.append(constructor.toGenericString() + "\n");
            }
        }
        sb.append("公共域：\n");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String modifier = Modifier.toString(field.getModifiers());
            if (modifier.contains("public")) {
                sb.append(field.toGenericString() + "\n");
            }
        }
        sb.append("公共方法：\n");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            if (modifier.contains("public")) {
                sb.append(method.toGenericString() + "\n");
            }
        }
        return sb.toString();
    }
}
