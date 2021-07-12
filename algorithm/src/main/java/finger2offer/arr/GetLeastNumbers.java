package finger2offer.arr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//获取k个小的数
public class GetLeastNumbers {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 6, 1, 6, 8, 0};
		System.out.println(GetLeastNumbers_Solution1(arr, 5));
	}

	public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (input == null || k <= 0 || k > input.length) {
			return res;
		}
		Queue<Integer> q = new PriorityQueue<>(k, Collections.reverseOrder());

		for (int i = 0; i < input.length; i++) {
			if (q.size() < k) {
				q.add(input[i]);
			} else {
				if (input[i] < q.peek()) {
					q.remove();
					q.add(input[i]);
				}
			}
		}
		while (!q.isEmpty()) {
			res.add(q.remove());
		}
		return res;
	}

	public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		if (input == null || k <= 0 || k > input.length) {
			return res;
		}
		int kth = kthMin(k, input, 0, input.length - 1);
		for (int i = 0; i < input.length && res.size() < k; i++) {
			if (input[i] <= kth) {
				res.add(input[i]);
			}
		}
		return res;
	}

	public static int kthMin(int k, int[] arr, int left, int right) {
		int i = left;
		int j = right;
		while (i < j) {
			while (i < j && arr[i] < arr[j])
				j--;
			if (i < j) {
				swap(arr, i, j);
				i++;
			}
			while (i < j && arr[i] < arr[j])
				i++;
			if (i < j) {
				swap(arr, i, j);
				j--;
			}
		}
		if (k == j - left + 1)
			return arr[j];
		else if (k < j - left + 1)
			return kthMin(k, arr, left, j - 1);
		else
			return kthMin(k - (j - left + 1), arr, j + 1, right);
	}

	public static void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
}
