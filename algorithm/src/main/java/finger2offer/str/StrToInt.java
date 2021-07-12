package finger2offer.str;

public class StrToInt {
    public static void main(String[] args) {
        System.out.println(strToInt("1a33"));
    }

    private static int strToInt(String str) {
        if (str.length() == 0
                || str.charAt(0) != '+' && str.charAt(0) != '-' && (str.charAt(0) < '0' || str.charAt(0) > '9')) {
            return 0;
        }
        if ((str.charAt(0) == '+' || str.charAt(0) == '-') && str.length() == 1) {
            return 0;
        }
        for (int i = 1; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > '9')) {
                return 0;
            }
        }
        int res = Integer.valueOf(str);
        return res;
    }
}