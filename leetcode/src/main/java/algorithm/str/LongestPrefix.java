package algorithm.str;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        String ret = longestCommonPrefix1(arr);
        System.out.println(ret);
    }


    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            while (!strs[i].startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;
    }

    public static String longestCommonPrefix2(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        int minLen = strs[0].length();
        int indexEnd = 0;
        for (int i = 1; i < len; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return strs[0].substring(0, indexEnd);
                }
            }
            indexEnd++;
        }
        return strs[0].substring(0, indexEnd);
    }
}