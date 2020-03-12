package algorithm.str;

public class ChangeSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("a b c");
        ReplaceSpace.replaceSpace(str);
        System.out.println(str);
    }
}

class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        int len_old = str.length() - 1;
        for (int i = 0; i <= len_old; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");
        int len_new = str.length() - 1;
        while (len_old >= 0 && len_old < len_new) {
            char ch = str.charAt(len_old--);
            if (ch == ' ') {
                str.setCharAt(len_new--, '0');
                str.setCharAt(len_new--, '2');
                str.setCharAt(len_new--, '%');
            } else {
                str.setCharAt(len_new--, ch);
            }
        }
        return str.toString();
    }
}