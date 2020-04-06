package old.str;

class SaleStack {
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length-1&& prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
/*    public int maxProfit(int[] prices) {
        //出现差值就是增益
        int sum = 0 ;
        int differ;
        int len = prices.length-1;
        for(int day = 0 ; day < len ; day++){
            differ = prices[day+1]-prices[day];
            if(differ > 0){
                sum += differ;
            }
        }
        return sum;
    }*/
}