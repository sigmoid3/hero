package algorithm.str;

class OnceStack {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int max = 0;
        int minPrices = prices[0];
        for(int i=1;i<prices.length;i++){
            minPrices = Math.min(minPrices,prices[i]);
            max = Math.max(max,prices[i]-minPrices);
        }
        return max;
    }
}