package old.str;

import java.util.Scanner;

class Solution1 {

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
    public String decodeAtIndex(String S, int K) {
        long si = 0;
        for (int i = 0; i < S.length(); i++) {
            if (isDigit(S.charAt(i)))
                si *= (S.charAt(i) - '0');
            else si++;
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            K %= si;
            if (K == 0 && !isDigit(S.charAt(i))) return ""+S.charAt(i);
            if (isDigit(S.charAt(i))) si /= (S.charAt(i) - '0');
            else si--;
        }
        return "";
    }
}

//test
public class DecodeAtIndex {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
		Integer idx = scanner.nextInt();
		scanner.close();
        String result = sol.decodeAtIndex(str,idx);
        System.out.println(result);
    }
}
