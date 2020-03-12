package algorithm.dp;
/**
 * 最大股票收益
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            ret = Math.max(ret, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return ret;
    }
}