package algorithm.sort;

public class MaxSubSequence {
	public static void main(String[] args) {
		int[] num = {1, 3, -2, 4, -5};
		MaxSubSequence ms = new MaxSubSequence();
		System.out.println(ms.maxSequence(num));
	}
	public int maxSequence(int[] arg) {
		int maxnum, maxcurr;
		maxnum = maxcurr = arg[0];
		for (int i = 1; i < arg.length; i++) {
			if (maxcurr <= 0) {
				maxcurr = arg[i];
			} else {
				maxcurr += arg[i];
			}
			if (maxcurr > maxnum) {
				maxnum = maxcurr;
			}
		}
		return maxnum;
	}
}