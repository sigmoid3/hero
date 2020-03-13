package finger2offer.str;

public class IsNumeric {
    public static void main(String[] args) {
        String str = "+++01";
        System.out.println(isNumbric1(str.toCharArray()));
    }

    private static boolean isNumbric1(char[] str) {
        if (str == null || str.length == 0)
            return false;
        return new String(str).matches("[+-] ? \\d* (\\. \\d+) ? ([eE] [+-] ? \\d + )?");
    }

    private static boolean isNumbric2(char[] str) {
        int len = str.length;
        int eidx = -1;
        int didx = -1;
        int fidx = -1;
        boolean eflag = true;
        boolean dflag = true;
        if (len == 1 && !(str[0] >= '0' && str[0] <= '9') || ((str[0] == '+' || str[0] == '-') && (str[1] == '+' || str[1] == '-'))) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if ((str[i] >= 'a' && str[i] <= 'z' && str[i] != 'e') || (str[i] >= 'A' && str[i] <= 'Z' && str[i] != 'E')) {
                return false;
            }
            if (str[i] == 'e' || str[i] == 'E') {
                eidx = i;
                eflag = false;
            }
            if (str[i] == '.') {
                if (!dflag || !eflag) {
                    return false;
                }
                dflag = false;
            }
        }
        for (int i = 1; i < len; i++) {
            if (str[i] == '+' || str[i] == '-') {
                fidx = i;
            }
            if (str[i] == '+' || str[i] == '-') {
                if (!(str[i - 1] == 'e' || str[i - 1] == 'E')) {
                    return false;
                }
            }
        }
        return eidx != 0 && eidx != len - 1;
    }
}