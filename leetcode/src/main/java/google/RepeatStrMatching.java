package google;

import java.util.Scanner;

/**
 * @author: minqian
 * @since: 2020/10/18
 * @description: 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * <p>
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * 示例 1：
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 * <p>
 * 链接：https://leetcode-cn.com/leetbook/read/google-interview/1hdle/
 * 来源：力扣（LeetCode）
 */
public class RepeatStrMatching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            int times = b.length() / a.length();
            if (b.length() % a.length() != 0) {
                times++;
            }
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < times; i++) {
                result.append(a);
            }
            if (result.toString().contains(b)) {
                System.out.println(times);
            }
            result.append(a);
            if (result.toString().contains(b)) {
                System.out.println(times + 1);
            }
            System.out.println(-1);
        }
    }
}
