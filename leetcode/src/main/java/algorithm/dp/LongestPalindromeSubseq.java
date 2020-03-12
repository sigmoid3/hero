package algorithm.dp;

public class LongestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chArr = s.toCharArray();
        int n = chArr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = chArr[i] == chArr[i + 1] ? 2 : 1;
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = len + i - 1;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (chArr[i] == chArr[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                }
            }
        }
        return dp[0][n - 1];
    }
}