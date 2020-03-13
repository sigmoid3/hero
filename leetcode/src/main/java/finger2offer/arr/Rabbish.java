package finger2offer.arr;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: sandro
 * @Create: 2019-09-19
 * @Description: n个垃圾，其中输入的数组表示两个不能放在一起运走，输出最多一次性运走多少个垃圾。
 **/
public class Rabbish {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1 && m > 0) {
            System.out.println("-1");
            return;
        }
        int isoLen = 2;
        int[][] iso = new int[m][isoLen];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < isoLen; j++) {
                iso[i][j] = sc.nextInt();
            }
        }
        Set<Integer> bucket1 = new LinkedHashSet<>();
        Set<Integer> bucket2 = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            //直接贪心，为什么是&&，因为已有值不可添加，另一边有值也不可添加
            if (!bucket1.contains(iso[i][0]) && !bucket2.contains(iso[i][0])) {
                if (bucket1.size() >= bucket2.size()) {
                    bucket1.add(iso[i][0]);
                    bucket2.add(iso[i][1]);
                } else {
                    bucket2.add(iso[i][0]);
                    bucket1.add(iso[i][1]);
                }
            } else if (!bucket1.contains(iso[i][1]) && !bucket2.contains(iso[i][1])) {
                if (bucket1.size() >= bucket2.size()) {
                    bucket1.add(iso[i][1]);
                    bucket2.add(iso[i][0]);
                } else {
                    bucket2.add(iso[i][1]);
                    bucket1.add(iso[i][0]);
                }
            }
        }
        int ret = n - Math.min(bucket1.size(), bucket2.size());
        System.out.println(ret);
    }
}
