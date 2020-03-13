package finger2offer.bit;

public class Power {
    public static void main(String[] args) {
        System.out.println(Power2(2, 2));
    }

    private static double Power1(double base, int exponent) {
        if (base == 1 || exponent == 0) {
            return 1;
        }
        double ret = 1.0;
        int n = Math.abs(exponent);
        for (int i = 0; i < n; i++) {
            ret *= base;
        }
        return exponent > 0 ? ret : (1 / ret);
    }

    private static double Power2(double base, int exponent) {
        if (base == 1 || exponent == 0) {
            return 1;
        }
        double ret = 1.0;
        int n = Math.abs(exponent);
        while (n > 0) {
            if (n % 2 == 1)        //if(n&1)
                ret *= base;
            base *= base;
            n /= 2;        //n>>=1
        }
        return exponent > 0 ? ret : (1 / ret);
    }

    private static double Power3(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        //a>>1 equal a/2
        double ret = Power3(base, exponent >> 1);
        ret *= ret;
        //a&2 is equal a%2
        if ((exponent & 2) == 1) {
            ret *= base;
        }
        return ret;
    }
}