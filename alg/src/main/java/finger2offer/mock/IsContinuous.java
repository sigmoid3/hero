package finger2offer.mock;

public class IsContinuous {
    public static void main(String[] args) {
        int[] arr = {0, 0, 3, 5, 7};
        System.out.println(isContinuous(arr));
    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        int[] h = new int[14];
        int len = numbers.length;
        int max = -1, min = 14;
        for (int i = 0; i < len; i++) {
            h[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (h[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return max - min < 5;
    }
}