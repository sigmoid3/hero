package finger2offer.arr;

import java.util.HashMap;

//不能修改数组时，可以把该数组进行拷贝然后，进行查找
public class DuplicateInArrII {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 2, 4, 4};
        int length = numbers.length;
        //the duplication can only receive one element
        int[] duplication = new int[1];
        DuplicateInArrII dia = new DuplicateInArrII();
        boolean ret = dia.duplicate1(numbers, length, duplication);
        System.out.println(ret);
        System.out.println(duplication[0]);
        System.out.println(dia.duplicate2(numbers, length));
    }

    public boolean duplicate1(int[] numbers, int length, int[] duplication) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int val : numbers) {
            if (hash.containsKey(val)) {
                duplication[0] = val;
                return true;
            } else {
                hash.put(val, 1);
            }
        }
        return false;
    }

    public int duplicate2(int[] numbers, int length) {
        if (numbers.length == 0 || length <= 0) {
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRng(numbers, length, start, middle);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }
            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    public int countRng(int[] numbers, int length, int start, int end) {
        if (numbers.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] >= start && numbers[i] <= end)
                count++;
        }
        return count;
    }
}