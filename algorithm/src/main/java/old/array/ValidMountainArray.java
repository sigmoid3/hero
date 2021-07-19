package old.array;

public class ValidMountainArray {
	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(validMountainArray(A));
	}

	public static boolean validMountainArray(int[] A) {
		int len = A.length;
		int i = 0;
		int j = len - 1;
		int cnt = 0;
		while (cnt <= len && j > 1 && i < len - 1) {
			if (A[i] < A[i + 1]) {
				i++;
			}
			if (A[j] < A[j - 1]) {
				j--;
			}
			cnt++;
		}
		System.out.println(i);
		System.out.println(j);
        return i == j && i != 0 && j != len - 1;
	}
}