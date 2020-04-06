package old.str;/*
import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        String result = "";
        String bb = "abc def ghi";
        String[] split = bb.split(" ");
        System.out.println(Arrays.toString(split));
        for (int i = 0; i < split.length; i++) {
            result = result + " " + new StringBuffer(split[i]).reverse().toString();

        }
        System.out.println(result);
        System.out.println(reverse("abc"));
    }

	public static String reverse(String str) {
		if ((null == str) || (str.length() <= 1)) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}

}*/


public class ReverseString {

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String abc = reverseString.reverse("abcdefg");
        System.out.println(abc);
    }

    String reverse(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}