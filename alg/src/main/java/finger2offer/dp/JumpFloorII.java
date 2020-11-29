package finger2offer.dp;

public class JumpFloorII {
    public static void main(String[] args) {
        JumpFloorII fib = new JumpFloorII();
        System.out.println(fib.method(1));
        System.out.println(fib.method(2));
        System.out.println(fib.method(3));
        System.out.println(fib.method(4));
    }

    public int method(int target) {
        if (target <= 0) {
            return -1;
        }
        if (target < 2) {
            return 1;
        }
        return method(target - 1) * 2;
    }
}