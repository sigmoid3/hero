package finger2offer.bit;

public class NumberOf1 {
    public static void main(String[] args) {
        System.out.println(numberOf13(7));
    }

    //support unsigned int
    private static int numberOf11(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1)
                cnt++;
        }
        return cnt;
    }

    //not support unsigned int
    private static int numberOf12(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }

    //not support unsigned int
    private static int numberOf13(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n = (n - 1) & n;
        }
        return cnt;
    }

    //support unsigned int
    //each time move 1 to right and & with n ,then get the number of 1
    private static int numberOf14(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= (n - 1);
        }
        return cnt;
    }
}
