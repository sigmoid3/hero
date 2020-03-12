package algorithm.dp;

import java.util.*;

public class LengthOfLISequence {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLISequence(nums));
    }

    public static int lengthOfLISequence(int[] nums) {
        int n = nums.length;
        if (n <= 1) { return n; }
        int[] lengths = new int[n];
        int[] counts = new int[n];
        Arrays.fill(counts, 1);

        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < j; ++i) {
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j]) {
                        counts[j] += counts[i];
                    }
                }
            }
        }

        int longest = 0, ret = 0;
        for (int length : lengths) {
            longest = Math.max(longest, length);
        }
        for (int i = 0; i < n; ++i) {
            if (lengths[i] == longest) {
                ret += counts[i];
            }
        }
        return ret;
    }
}