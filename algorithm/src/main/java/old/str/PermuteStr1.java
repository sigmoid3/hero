package old.str;

import java.util.ArrayList;
import java.util.List;
public class PermuteStr1 {

	public static void main(String[] args) {
		PermuteStr1 sol = new PermuteStr1();
		String str1 = "abc";
		String str2 = "accd";
		System.out.println(sol.checkInclusion(str1, str2));
	}


	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		boolean success = false;
		if (len1 > len2) {
			return success;
		}
	//find the permutation of the first string and judge if the second string constains the frist one
		List<String> ret = new ArrayList<String>();
		permutation(s1.toCharArray(), 0, len1, ret);
		for (int i = 0; i < ret.size(); i++) {
			if (s2.indexOf(ret.get(i)) != -1) {
				success = true;
				break;
			}
		}
		return success;
	}


	public void permutation(char[] s, int from, int to , List<String> ret) {
		if (to < 1)
			return;
		if (from == to) {
			ret.add(s.toString());
			return;
		} else {
			for (int i = from; i < to; i++) {
				swap(s, i, from);
				permutation(s, from + 1, to , ret);
				swap(s, from, i);
			}
		}
	}

	public void swap(char[] s, int i, int j) {
		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}
}