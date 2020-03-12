package algorithm.str;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.io.*;

class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
       List<Integer> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        Arrays.sort(nums);
        int prev = nums[0];
        int count = 1;
        for(int i=1; i<=nums.length; i++) {
            if (i<nums.length) {
                if (prev == nums[i]) {
                    count ++;
                }
                else {
                    if (count > nums.length/3) {
                        results.add(prev);
                    }
                    prev = nums[i];
                    count = 1;
                }
            } else {
                if (count > nums.length/3){
                    results.add(prev);
                }
            }
        }
        return results;
    }
}

class MajorityElementIV {
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

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += number + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<Integer> ret = new MajorityElementII().majorityElement(nums);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}