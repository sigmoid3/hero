package algorithm.str;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int num = n;
        int x = 1; // 控制循环的次数
        int r1 = num - 1; // 控制个数
        int caculate = 1; // 判断是哪一种循环
        int tmp = 1; // 累加的数1,2,3
        int c = 0; // 行
        int r = 0; // 列
        if (n <= 0)
            return arr;
        if (n == 1) {
            arr[0][0] = 1;
            return arr;
        }
        for (int i = 0; i < 2 * num - 1; i++) {
            // 从左到右,行不变，列加1
            if (caculate == 1) {
                while (r1 > 0) {
                    arr[c][r++] = tmp++;
                    r1--;
                }
                // 如果不是第一个圈，个数需要减少1
                if (x != 1) {
                    c++;
                    r1 = num - x - 1;
                    r -= 1; // 前面列数加多一个1，这里减1
                } else
                    r1 = num - x;
                caculate++;
            }
            // 从上到下列不变行加1
            else if (caculate == 2) {
                while (r1 > 0) {
                    arr[c++][r] = tmp++;
                    r1--;
                }
                if (x != 1) {
                    r1 = num - x - 1;
                    c--; // 前面行数加多一个1，这里减1
                    r--; // 不是第一圈列数减1
                } else
                    r1 = num - x;
                caculate++;
            }
            // 从右到左，行不变列减一
            else if (caculate == 3) {
                while (r1 > 0) {
                    arr[c][r--] = tmp++;
                    r1--;
                }
                if (n <= 2) { // 只有两行两列的时候保证最后一个是正常的
                    r1 = 1;
                    while (r1 > 0) {
                        arr[c--][r] = tmp++;
                        r1--;
                    }
                }
                if (x != 1) {
                    x++; // 不是第一圈需要剪掉的个数增加一个
                    r1 = num - x - 1;
                    r++;
                    c--;
                } else
                    r1 = num - x;
                caculate++;
            }
            // 从下到上，列不变，行减一
            else {
                while (r1 > 0) {
                    arr[c--][r] = tmp++;
                    r1--;
                }
                r1 = num - x - 1;
                r++;
                c++;
                x++;
                caculate = 1;
            }
        }
        return arr;
    }
}