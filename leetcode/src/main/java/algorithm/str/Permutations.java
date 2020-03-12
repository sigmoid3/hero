package algorithm.str;

public class Permutations {

	public static void main(String[] args) {
		String str = "abcc";
		permute2(str);
	}

	public static void permute1(String str) {
		int from = 0;
		int to = str.length();
		char[] s = str.toCharArray();
		permutation1(s, from, to - 1);
	}

	public static void permutation1(char[] s, int from, int to) {
		if (to <= 1)
			return;
		if (from == to) {
			System.out.println(s);
		} else {
			for (int i = from; i < to; i++) {
				swap(s, i, from);
				permutation1(s, from + 1, to);
				swap(s, from, i);
			}
		}
	}

	private static boolean ifExisted(char[] s, int start, int end) {
		for (int i = 0; i < end; i++) {
			if (s[i] == s[end])
				return false;
		}
		return true;
	}

	public static void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	public static void permute2(String str) {
		int len = str.length();
		boolean[] used = new boolean[len];
		StringBuffer output = new StringBuffer(len);
		permutation2(str, len, output, used, 0);
	}

	public static void permutation2(String str, int len, StringBuffer output, boolean[] used, int position) {
		if (position == len) {
			System.out.println(output.toString());
			return;
		} else {
			for (int i = 0; i < len; i++) {
				// skip if used
				if (used[i])
					continue;
				// add fixed character to output and mark it as used
				output.append(str.charAt(i));
				used[i] = true;
				// permute over remaining character starting at position+1
				permutation2(str, len, output, used, position + 1);
				// remove fixed character from output and unmark it
				output.deleteCharAt(output.length() - 1);
				used[i] = false;
			}
		}
	}
}