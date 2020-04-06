package old.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    private Deque<Integer> mainStack;
    
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        mainStack.push(x);
        
        Integer min = minStack.peek();
        if (min == null || x <= min) {
            minStack.push(x);
        }
    }
    
    public int pop() {
        int cur = mainStack.pop();
        if (cur == minStack.peek()) {
            minStack.pop();
        }
        return cur;
        
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}