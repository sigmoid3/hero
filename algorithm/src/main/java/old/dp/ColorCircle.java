package old.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColorCircle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //n number,m minwid,c color count
        int n, m, c;
        n = scan.nextInt();
        m = scan.nextInt();
        c = scan.nextInt();
        List<List<Integer>> circle = new ArrayList<List<Integer>>();
		List<Integer> ball = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			int cnt = scan.nextInt();
			for (int k = 0; k < cnt; k++) {
				ball.add(scan.nextInt());
			}
			circle.add(ball);
		}
		scan.close();
		//the rule is m width
		int count = 0;
		System.out.println(count);
	}
}