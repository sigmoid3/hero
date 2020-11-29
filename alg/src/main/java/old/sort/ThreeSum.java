package old.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4};
		System.out.println(ts.threeSum(nums));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		//sort can be used for the left and right
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			int left = i + 1, right = nums.length - 1;
			//the pre condition cannot miss "left<right"
			while (left < right) {
				List<Integer> step = new ArrayList<Integer>();
				int sum = nums[left] + nums[right] + nums[i];
				if (sum == 0) {
					step.add(nums[i]);
					step.add(nums[left]);
					step.add(nums[right]);
					//judge curent ret whether have contained in the ret,if not put in
					if (!ret.contains(step)) {
						ret.add(step);
					}
				}
				if (sum <= 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return ret;
	}
}