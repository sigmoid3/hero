package finger2offer.dp;

public class JumpFloor {
    public static void main(String[] args) {
        JumpFloor fib = new JumpFloor();
        System.out.println(fib.method(1));
        System.out.println(fib.method(2));
        System.out.println(fib.method(3));
        System.out.println(fib.method(4));
    }

    public long method(long target) {
        if (target <= 0) {
            return -1;
        }
        if (target < 3) {
            return target;
        }
        long first = 1;
        long second = 2;
        long ret = 0;
        for (long i = 3; i <= target; i++) {
            ret = first + second;
            first = second;
            second = ret;
        }
        return ret;
    }
}