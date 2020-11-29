package finger2offer.greedy;

public class MaxProductAfterCutting {
    public static void main(String[] args) {
        int ret = maxProductAfterCutting2(8);
        System.out.println(ret);
    }

    //greedy,after calculating,more 3time and less 2time
    private static int maxProductAfterCutting2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (length - timesOf3 * 3) / 2;
        int max = (new Double(Math.pow(3, timesOf3) * Math.pow(2, timesOf2))).intValue();
        return max;
    }
}