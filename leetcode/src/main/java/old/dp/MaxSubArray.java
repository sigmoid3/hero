package old.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxSubArray {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static  int maxSubArray(int[] nums) {
        int len = nums.length;
        int sum = 0;
        int ret = nums[0];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            ret = Math.max(ret, sum);
            sum = Math.max(0, sum);
        }
        return ret;
    }

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] nums = stringToIntegerArray(line);
                int ret = maxSubArray(nums);
                String out = String.valueOf(ret);
                System.out.print(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}