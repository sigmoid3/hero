package finger2offer.arr;

import java.util.ArrayList;

public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(15));
    }

    private static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int tail = 2;
        int head = 1;
        int mid = (1 + sum) / 2;
        int cnt = head + tail;
        while (head < mid) {
            if (cnt == sum) {
                res.add(addToRes(head, tail));
            }
            //当前和过大，则前部向后移
            while (cnt > sum && head < mid) {
                cnt -= head;
                head++;
                //和符合则添加大结果集
                if (cnt == sum) {
                    res.add(addToRes(head, tail));
                }
            }
            //尾部继续移动并加值
            tail++;
            cnt += tail;
        }
        return res;
    }

    private static ArrayList<Integer> addToRes(int head, int tail) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = head; i <= tail; i++) {
            tmp.add(i);
        }
        return tmp;
    }
}