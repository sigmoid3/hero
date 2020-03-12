package algorithm.str;

import java.util.*;
public class PermuteStr2 {
	public static void main(String[] args) {
		PermuteStr2 sol = new PermuteStr2();
		String str1 = "acc";
		String str2 = "abcd";
		System.out.println(sol.checkInclusion(str1, str2));
	}

	//move windows
	//change the problem from special format permute to number count in a move window
	public boolean checkInclusion(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 > len2) {
			return false;
		}
		int[] map1 = new int[26];
		int[] map2 = new int[26];
		for (char c : s1.toCharArray()) {
			//count the number of the character append
			map1[c - 'a']++;
		}
		for (int i = 0; i < len2; i++) {
			if (i >= len1)
				--map2[s2.charAt(i - len1) - 'a'];
			map2[s2.charAt(i) - 'a']++;
			if (Arrays.equals(map1, map2))
				return true;
		}
		List<int[]> list = Arrays.asList(map1);
		System.out.println(list);
		return false;
	}
}