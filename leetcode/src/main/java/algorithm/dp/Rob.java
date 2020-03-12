package algorithm.dp;
import java.util.*;

public class Rob {
    public static int[] ret;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        ret = new int[nums.length];
        Arrays.fill(ret, -1);
        return solve(nums.length - 1, nums);
    }

    public static int solve(int idx, int[] nums) {
        if (idx < 0) {
            return 0;
        }
        if (ret[idx] >= 0) {
            return ret[idx];
        }
        ret[idx] = Math.max(nums[idx] + solve(idx - 2, nums), solve(idx - 1, nums));
        return ret[idx];
    }
}