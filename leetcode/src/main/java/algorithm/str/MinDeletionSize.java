package algorithm.str;

public class MinDeletionSize {
	public static void main(String[] args) {
		String[] A = { "zyx", "wvu", "tsr" };
		System.out.println(minDeletionSize(A));
	}

	public static int minDeletionSize(String[] A) {
		int length = A[0].length();
		int res = 0;
		for (int i = 0; i < length; i++) {
			char pre = 'a';
			char cur = 'a';
			for (int j = 0; j < A.length; j++) {
				cur = A[j].charAt(i);
				if (cur < pre) {
					res++;
					break;
				}
				pre = cur;
			}
		}
		return res;
	}
}