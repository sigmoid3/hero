package finger2offer.arr;

import java.util.Comparator;
import java.util.PriorityQueue;

public class GetMedian {
    private int cnt = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
        @Override
        public int compare(Integer a1, Integer a2) {
            return a2 - a1;
        }
    });

    public void insert(Integer num) {
        if (cnt % 2 == 0) {
            maxHeap.offer(num);
            int filteredMaxNum = maxHeap.poll();
            minHeap.offer(filteredMaxNum);
        } else {
            minHeap.offer(num);
            int filteredMinNum = minHeap.poll();
            maxHeap.offer(filteredMinNum);
        }
        cnt++;
    }

    public Double getMedian() {
        if (cnt % 2 == 0) {
            return new Double((minHeap.peek() + maxHeap.peek())) / 2;
        } else {
            return new Double(minHeap.peek());
        }
    }
}