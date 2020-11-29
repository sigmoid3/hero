package finger2offer.dp;

import java.util.Scanner;

/**
 * @Author: sandro
 * @Create: 2019-09-21
 * @Description: a[i]比前i-1项的和大组成的连续数列为完美子序列
 **/
public class PerfectSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] sum = new int[n + 1];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            int tmp = 0;
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] >= sum[j]) {
                    sum[j + 1] = sum[j] + a[j];
                    tmp++;
                    max = Math.max(max, tmp);
                } else {
                    tmp = 1;
                    sum[j + 1] = a[j];
                }
            }
            System.out.println(max);
        }
    }
}
