package finger2offer.arr;

public class NumberOf1Between1andN {

    public int numberOf1Between1andN2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i, b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }

    public int numberOf1Between1andN1(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            cnt += numberOf1(i);
        }
        return cnt;
    }

    public static int numberOf1(int a) {
        int cnt = 0;
        while (a != 0) {
            if (a % 10 == 1) {
                cnt++;
            }
            a /= 10;
        }
        return cnt;
    }
}