package finger2offer.arr;

public class Multiply {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = multiply2(A);
        for (int val : B) {
            System.out.println(val); // 120 60 40 30 24
        }
    }

    public static int[] multiply1(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            int res = 1;
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                }
                res *= A[j];
            }
            B[i] = res;
        }
        return B;
    }

    public static int[] multiply2(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (len != 0) {
            B[0] = 1;
            for (int i = 1; i < len; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int tmp = 1;
            for (int j = len - 2; j >= 0; j--) {
                tmp *= A[j + 1];
                B[j] *= tmp;
            }
        }
        return B;
    }
}