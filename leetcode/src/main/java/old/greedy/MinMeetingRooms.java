package old.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: sandro
 * @Create: 2019-09-20
 * @Description:
 **/
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) { return 0; }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ret = 0;
        for (int i = 0; i < intervals.length; i++) {
            minHeap.offer(intervals[i][1]);
            if (!minHeap.isEmpty()) {
                if (intervals[i][0] < minHeap.peek()) {
                    ret++;
                } else {
                    minHeap.poll();
                }
            }
        }
        return ret;
    }
}
