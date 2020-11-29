package old.str;

import java.util.Scanner;

public class MoveChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(upperBack(str));
        }
        scan.close();
    }

    public static char[] upperBack(String str) {
        char[] strArr = str.toCharArray();
        int j;
        int len = strArr.length;
        for (int i = len - 1; i > 0; i--) {
            if (Character.isLowerCase(strArr[i])) {
                j = i;
                while (Character.isLowerCase(strArr[j]) && j >= 1) {
                    j--;
                }
                if (j == 0 && Character.isLowerCase(strArr[j])) {
                    break;
                }
                if (Character.isUpperCase(strArr[j])) {
                    char temp = strArr[j];
                    for (int k = j; k < i; k++) {
                        strArr[k] = strArr[k + 1];
                    }
                    strArr[i] = temp;
                }

            }
        }
        return strArr;
    }
}