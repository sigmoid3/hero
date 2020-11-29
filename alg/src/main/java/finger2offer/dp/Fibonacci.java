package finger2offer.dp;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.method(8));
    }

    public int method(int n) {
        if (n < 3) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int ret = 0;
        for (int i = 2; i <= n; i++) {
            ret = first + second;
            first = second;
            second = ret;
            System.out.println(ret);
        }
        return ret;
    }
}