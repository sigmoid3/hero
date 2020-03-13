package finger2offer.bit;

public class SumBit {
    public static void main(String[] args) {
        int ret = sumBit(10);
        System.out.println(ret);
    }

    private static int sumBit(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += sumBit(n - 1)) > 0);
        return sum;
    }
}