package old.str;

import java.util.Scanner;

public class LessReverse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(str.length() - getResult(str));
        }
        scan.close();
    }

    public static int getResult(String str) {
        StringBuilder feer = new StringBuilder(str);
        String newStr = feer.reverse().toString();
        char[] str1 = str.toCharArray();
        char[] str2 = newStr.toCharArray();
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}