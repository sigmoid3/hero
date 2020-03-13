package finger2offer.arr;

public class CharToNum {
    public static void main(String[] args) {
        int ret = charToSum("AB");
        System.out.println(ret);
    }

    private static int charToSum(String str) {
        char[] arr = str.toCharArray();
        int exp = 0;
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int num = arr[i] - 'A' + 1;
            sum += num * ((int) Math.pow(26, exp));
            exp++;
        }
        return sum;
    }
}