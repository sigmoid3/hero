package old.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qmq
 * Input: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * Output: 14
 * Explanation:
 * There are two kinds of items, A and B. Their prices are $2 and $5 respectively.
 * In special offer 1, you can pay $5 for 3A and 0B
 * In special offer 2, you can pay $10 for 1A and 2B.
 * You need to buy 3A and 2B, so you may pay $10 for 1A and 2B (special offer #2), and $4 for 2A.
 * note:
 * There are at most 6 kinds of items, 100 special offers.
 * For each item, you need to buy at most 6 of them.
 * You are not allowed to buy more items than you want, even if that would lower the overall price.*
 *
 * @ 18-10-8
 **/

public class ShoppingOffer {
    public static void main(String[] args) {
        List<Integer> age = new ArrayList<>();
        age.add(23);
        age.add(24);
        List<Integer> newage = age.subList(0, 1);
        System.out.println(newage);
        System.out.println(age.toString());
    }

    boolean checkvalid(List<Integer> needs, List<Integer> special) {
        for (int j = 0; j < needs.size(); ++j) {
            if (needs.get(j) < special.get(j)) {
                return false;
            }
        }
        return true;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {

        int minPrice = 0;
        for (int i = 0; i < needs.size(); ++i) {
            //不使用折扣方案的价格
            minPrice += needs.get(i) * price.get(i);
        }

        for (int i = 0; i < special.size(); ++i) {
            if (checkvalid(needs, special.get(i))) {
                //校验是否符合每个需求量大于优惠方案数量，若均不符合则直接使用不折扣方案
                List<Integer> curNeeds = new ArrayList<>();
                for (int j = 0; j < needs.size(); ++j) {
                    curNeeds.add(needs.get(j) - special.get(i).get(j));         // 子需求量 = 当前需求量-方案提供量
                }
                int tempPrice = shoppingOffers(price, special, curNeeds) + special.get(i).get(needs.size());
                //子方案递归选择+当前方案金额
                minPrice = Math.min(minPrice, tempPrice);
                //获取最低价格，可能不使用折扣方案更便宜
            }
        }
        return minPrice;
    }

}
