package finger2offer.str;

import java.math.BigInteger;
import java.util.Arrays;

public class PrintToMaxDigits {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        printToMaxDigits2(3); // *better performance
        // printToMaxDigits1(3);
        long endTime = System.currentTimeMillis();
        System.out.println("Time Spending :" + (endTime - startTime) + "ms");
    }

    private static void printToMaxDigits1(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n + 1];
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            toMax(number, n, 0);
        }
    }

    private static void toMax(char[] number, int length, int idx) {
        if (idx == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[idx + 1] = (char) (i + '0');
            toMax(number, length, idx + 1);
        }
    }

    private static void printNumber(char[] number) {
        boolean isZero = true;
        int len = number.length;
        for (int i = 0; i < len; i++) {
            if (isZero && number[i] != '0') {
                isZero = false;
            }
            if (!isZero) {
                System.out.print(number[i]);
            }
        }
    }

    private static void printToMaxDigits2(int n) {
        int[] a = new int[n];
        StringBuffer sb = new StringBuffer();
        Arrays.fill(a, 9);
        for (int val : a) {
            sb.append(val);
        }
        BigInteger max = new BigInteger(sb.toString());
        max = max.add(BigInteger.ONE);
        for (BigInteger i = BigInteger.ONE; i.compareTo(max) < 0; i = i.add(BigInteger.ONE)) {
            System.out.println(i);
        }
    }
}