package finger2offer.arr;

import java.util.ArrayList;

public class GetUglyNumber {
    public static void main(String[] args) {
        int ret = getUglyNumber2(15);
        System.out.println(ret);
    }

    private static int getUglyNumber1(int index) {
        if (index <= 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {
            int j2 = list.get(i2) * 2;
            int j3 = list.get(i3) * 3;
            int j5 = list.get(i5) * 5;
            int min = Math.min(j2, Math.min(j3, j5));
            list.add(min);
            if (min == j2)
                i2++;
            if (min == j3)
                i3++;
            if (min == j5)
                i5++;
        }
        return list.get(list.size() - 1);
    }

    private static int getUglyNumber2(int index) {
        if (index <= 0)
            return 0;
        int i = 0, j = 1;
        while (i < index) {
            if (isUglyNumber(j)) {
                i++;
            }
            j++;
        }
        return j - 1;
    }

    private static boolean isUglyNumber(int number) {
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1;
    }
}