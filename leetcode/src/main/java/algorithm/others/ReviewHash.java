package algorithm.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class ReviewHashSolution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                count = 1;
            } else {
                count++;
            }
            map.put(num, count);
            if (map.get(num) > n / 2) {
                return num;
            }
        }
        return 0;
    }
}

public class ReviewHash {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new ReviewHashSolution().majorityElement(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

