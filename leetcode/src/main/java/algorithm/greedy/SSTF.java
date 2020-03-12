package algorithm.greedy;

import java.util.*;

public class SSTF {

	private int shortIndex = 0;
	private int visit[];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input the number of request: ");
		int num = scanner.nextInt();
		System.out.println("please input the sequence of request with space separate: ");
		int data[] = new int[num];
		for (int i = 0; i < num; i++) {
			data[i] = scanner.nextInt();
		}
		SSTF sstf = new SSTF();
		System.out.println("please input the position of the header: ");
		int begin = scanner.nextInt();
		sstf.print(sstf.sstf(data, begin), begin);
		scanner.close();
	}

	public int[] sstf(int data[], int begin) {
		int nearest = 99999;
		visit = new int[data.length];
		for (int j = 0; j < data.length; j++) {
			for (int i = 0; i < data.length; i++) {
				if (data[i] != -1) {
					if (Math.abs(nearest - begin) > Math.abs(data[i] - begin)) {
						nearest = data[i];
						shortIndex = i;
					}
				}
			}
			visit[j] = nearest;
			data[shortIndex] = -1;
			begin = nearest;
			nearest = 99999;
		}
		return visit;
	}

	public void print(int visit[], int begin) {
		for (int i = 0; i < visit.length; i++) {
			System.out.print(visit[i] + "     ");
		}
		int length = 0;
		for (int i = 0; i < visit.length - 1; i++) {
			length += Math.abs(visit[i] - visit[i + 1]);
		}
		length += Math.abs(begin - visit[0]);
		System.out.println("the average length: " + length / visit.length);
	}
}
