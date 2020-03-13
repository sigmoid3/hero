package finger2offer.mock;

public class LastRemaining {
    public static void main(String[] args) {
        System.out.println(lastRemaining1(2, 1));
        System.out.println(lastRemaining2(2, 1));
    }

    private static int lastRemaining1(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        } else {
            return (lastRemaining1(n - 1, m) + m) % n;
        }
    }

    private static int lastRemaining2(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        int[] array = new int[n];
        // i,step,cnt分别表示当前被删除对象,已走过的,人数
        int i = -1, step = 0, cnt = n;
        while (cnt > 0) {
            i++;
            if (i >= n)
                i = 0;
            if (array[i] == -1)
                continue;
            step++;
            if (step == m) {
                array[i] = -1;
                step = 0;
                cnt--;
            }
        }
        return i;
    }
}