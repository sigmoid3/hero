package old.str;

import java.util.ArrayList;
import java.util.List;

public class Duplicate {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 3, 4 };
        Duplicate t = new Duplicate();
        List<Integer> ret = t.findDuplicate(nums);
        System.out.println(ret);
    }

    public List<Integer> findDuplicate(int[] nums) {
        int first = 0, second = 0, tmp = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            // fast and slow pointers
            first = nums[first];
            second = nums[nums[second]];
            if (first == second)
                break;
        }
        while (tmp != second) {
            tmp = nums[tmp];
            second = nums[second];
        }
        list.add(tmp);
        return list;
    }
}
