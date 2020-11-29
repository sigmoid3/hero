package old.str;//jinri offer2.2017 backend

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//at least three
//the longest one must be shorter than sum of all edge
public class Wood {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        Wood w = new Wood();
        int n = scan.nextInt();
        int op, len;
        for (int i = 0; i < n; i++) {
			op = scan.nextInt();
			len = scan.nextInt();
			if (op == 1) {
				list.add(len);
			} else {
                list.remove((Integer) len);
            }
			w.ifContruct(list);
		}
		scan.close();
	}
	public void ifContruct(List<Integer> list) {
		if (list.size() < 3)
			System.out.println("No");
		int maxLen = list.get(0);
		int sum = 0;
		for (int i : list) {
			maxLen = i > maxLen ? i : maxLen;
			sum += i;
		}
		if (maxLen >= sum - maxLen) {
			System.out.println("No");
		}
		System.out.println("Yes");
	}
}