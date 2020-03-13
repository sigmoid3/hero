package finger2offer.dp;

public class FindGreatestSumOfSubArray {
    public static void main(String[] args) {
        int[] array = {6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray(array));
    }

    public static int findGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if (len == 0 || array == null) {
            return 0;
        }
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (sum <= 0) {
                // 若小于0时，更新为当前值
                sum = array[i];
            } else {
                // 正值可直接加上
                sum += array[i];
            }
            //比较，若都为负数，依然取较大即可
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}