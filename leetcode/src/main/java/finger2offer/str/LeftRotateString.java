package finger2offer.str;

public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcXYZdef";
        System.out.println(leftRotateString(str, 3));
    }

    public static String leftRotateString(String str, int n) {
        if (str.length() == 0) {
            return "";
        }
        String tail = new StringBuffer(str.substring(0, n)).reverse().toString();
        String head = new StringBuffer(str.substring(n)).reverse().toString();
        String res = new StringBuffer(tail + head).reverse().toString();
        return res;
    }
}