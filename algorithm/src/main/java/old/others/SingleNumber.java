package old.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class SingleNumber{

/*	public int singleNumber(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			Integer value = map.get(nums[i]);
			map.put(nums[i], (value == null ? 0 : value) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return 0;
	}*/

/*	public int singleNumber2(int[] nums) {
		int res = 0;
		for (int i : nums) {
			res ^= i;
		}
		return res;
	}*/

	public int singleNumber(int[] nums){
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i+=2){
			if(i+1>=nums.length){
				return nums[i];
			}
			if(nums[i]!=nums[i+1]){
				return nums[i];
			}
		}
		return -1;
	}

}

class MainClassSolution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			Integer value = map.get(nums[i]);
			map.put(nums[i], (value == null ? 0 : value) + 1);
		}
        boolean result = false;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				result = true;
			}
    }
        return result;
}
}

class SingleNumberI {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            
            boolean ret = new MainClassSolution().containsDuplicate(nums);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}