package algorithm.str;

import java.util.*;

public class LongestNoRepeat {
	public static void main(String[] args) {
		String str = "aau";
		int ret = lengthOfLongestSubstring(str);
		System.out.println(ret);
	}

	// not as same as the longest sub-sequence which neednot be linked
	// the worst solution
	public static int lengthOfLongestSubstring1(String s) {
		// find the sequence which is the biggest length as return
		int len = s.length();
		int maxCount = 0;
		if (len == 0) {
			return 0;
		}
		if (len == 1) {
			return 1;
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if (ifNoRepeat(s.substring(i, j))) {
					if ((j - i) > maxCount) {
						maxCount = j - i;
					}
				} else {
					break;
				}
			}
		}
		return maxCount;
	}

	public static boolean ifNoRepeat(String str) {
		boolean ret = true;
		int len = str.length();
		if (len > 1) {
			for (int i = 0; i < len; i++) {
				if (str.substring(0, i).contains(str.substring(i, i + 1))) {
					ret = false;
					break;
				}
			}
		}
		return ret;
	}

	public static int lengthOfLongestSubstring(String s) {
		char[] strArr = s.toCharArray();
		if(strArr.length==1){
			return 1;
		}
		Map<Character,Integer> map = new HashMap<>();
		for(int i=0;i<strArr.length;i++){
			if(map.containsKey(strArr[i])){
				map.put(strArr[i],map.get(strArr[i])+1);
			}else{
				map.put(strArr[i],1);
			}
		}
		int max = map.size();
		int lenMax;
		for(lenMax = max;lenMax > 0 ;lenMax--){
			for(int i = 0;i <= s.length() - lenMax; i++){
				if(isNoRepeat(s.substring(i,i+lenMax))){
					return lenMax;
				}
			}
		}
		return 0;
	}
	private static boolean isNoRepeat(String s){
		char[] strArr = s.toCharArray();
		Map<Character,Boolean> flag = new HashMap<>();
		for(int i=0;i<strArr.length;i++){
			if(flag.containsKey(strArr[i])){
				return false;
			}
			flag.put(strArr[i],true);
		}
		return true;
	}

	// the best solution,use i,j two pointer as the biggest
	public static int lengthOfLongestSubstring2(String s) {
		int max = 0;
		int left = 0;
		int right = 0;
		for (; right < s.length(); ++right) {
			// to get the current element
			char rightC = s.charAt(right);
			for (int index = left; index < right; ++index) {
				// judge the element if it equal the right element
				if (s.charAt(index) == rightC) {
					// choose the max length
					max = (right - left) > max ? (right - left) : max;
					left = index + 1;
					break;
				}
			}
		}
		// ensure the last judge
		max = (right - left) > max ? (right - left) : max;
		return max;
	}

	public static int lengthOfLongestSubstring3(String s) {
		Set<Character> set = new HashSet<Character>();
		int i = 0, j = 0;
		int n = s.length();
		int maxLen = 0;
		while (i <= j && j < n) {
			char c = s.charAt(j);
			// if element didnot exist,then putin and move tail to right
			if (!set.contains(c)) {
				set.add(c);
				maxLen = Math.max(set.size(), maxLen);
				j++;
			} else {
				// if element has existed,then move head to right
				set.remove(s.charAt(i++));
			}
		}
		return maxLen;
	}

	public static int lengthOfLongestSubstring4(String s) {
		StringBuffer stringBuffer = new StringBuffer();
		int result = 0;
		int i = 0;
		int j = 0;
		while (i < s.length()) {
			if (!stringBuffer.toString().contains(s.charAt(i) + "")) {
				stringBuffer.append(s.charAt(i));
				i++;
			} else {
				result = result > stringBuffer.length() ? result : stringBuffer.length();
				stringBuffer.delete(0, stringBuffer.length());
				j++;
				i = j;
			}
		}
		return result > stringBuffer.length() ? result : stringBuffer.length();
	}

	public static int lengthOfLongestSubstring5(String s) {
		List<Character> list = new ArrayList<Character>();
		char[] inputChars = s.toCharArray();
		int i, j = 0, maxLength = 0;
		for (i = 0; i < inputChars.length; i++) {
			list.add(inputChars[i]);
			if (i + 1 < inputChars.length && list.contains(inputChars[i + 1])) {
				int index = list.indexOf(inputChars[i + 1]);
				i = index + j;
				j = i + 1;
				maxLength = Math.max(maxLength, list.size());
				list.clear();
			}
		}
		maxLength = Math.max(maxLength, list.size());
		return maxLength;
	}

	public static int lengthOfLongestSubstring6(String s) {
		if (s == null || s.length() == 0)
			return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int res = 0;
		int len = 0;
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			// move the start position to right
			if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
				start = map.get(s.charAt(i)) + 1;
			}
			// update the length
			len = i - start + 1;
			// update the last s right
			map.put(s.charAt(i), i);
			/// choose the longest one
			res = Math.max(res, len);
		}
		return res;
	}

}