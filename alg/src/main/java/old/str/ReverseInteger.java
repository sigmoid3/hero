package old.str;

/**
 * @Author: minqian
 * @Create: 2020/3/13
 * @Description:
 **/
public class ReverseInteger {
    public int p(int x) {
        int term;
        long b = 0;
        while (x != 0) {
            term = x % 10;
            x = x / 10;
            b = b * 10 + term;
        }
        if (b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) {
            return 0;
        }
        System.out.println(b);
        return (int) b;
    }
}
