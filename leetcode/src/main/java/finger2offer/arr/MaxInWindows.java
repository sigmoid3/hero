package finger2offer.arr;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0)
            return res;
        int head;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            head = i - size + 1;
            if (dq.isEmpty())
                dq.add(i);
            else if (head > dq.peekFirst())
                dq.pollFirst();

            while ((!dq.isEmpty()) && num[dq.peekLast()] <= num[i])
                dq.pollLast();
            dq.add(i);
            if (head >= 0)
                res.add(num[dq.peekFirst()]);
        }
        return res;
    }
}