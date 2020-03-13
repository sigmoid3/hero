package finger2offer.arr;

public class DuplicateInArr {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 3, 2, 4, 4};
        int length = numbers.length;
        //the duplication can only receive one element
        int[] duplication = new int[1];
        DuplicateInArr dia = new DuplicateInArr();
        boolean ret = dia.duplicate(numbers, length, duplication);
        System.out.println(ret);
        for (int val : duplication) {
            System.out.println(val);
        }
    }

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (length < 2 || numbers == null) {
            return false;
        }
        for (int val : numbers) {
            if (val < 0 || val > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[i] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }
        }
        return false;
    }
}