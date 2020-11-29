package old.str;

import java.util.Scanner;

class Solution3 {

    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int[] number, int len) {
        for (int j = 0; j < len / 2; j++)
            if (number[j] != number[len - j - 1]) return false;
        return true;
    }

    public int primePalindrome(int number) {
        if (number <= 2) return 2;
        number = number % 2 == 0 ? number + 1 : number;
        for (int i = number; ; ) {
            int k = i, len = 0;
            int[] nums = new int[10];
            while (k / 10 != 0) {
                nums[len++] = k % 10;
                k /= 10;
            }
            nums[len++] = k;
            if (len % 2 == 0 && i != 11)
                i = (int) Math.pow(10, len) + 1;
            else {
                if (isPalindrome(nums, len))
                    if (isPrime(i)) return i;
                i += 2;
            }
        }

    }
}

public class PrimePalindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int read = scan.nextInt();
        Solution3 sol = new Solution3();
        scan.close();
        System.out.println(sol.primePalindrome(read));
    }
}