package old.str;//jinri toutiao offer1.2017 backend

import java.util.Arrays;
import java.util.Comparator;

public class MaxMap {
	public static void main(String[] args) {
		String[] arr = {
				"ABC",
				"BCA"
		};
		MaxMap mm = new MaxMap();
		long ret = mm.searchMaxMap(arr);
		System.out.println(ret);
	}
	public long searchMaxMap(String[] arr) {
		int len = arr.length;
		Element[] tag = new Element[10];
		for (int i = 0; i < 10; i++)
			tag[i] = new Element();
		for (int i = 0; i < len; i++) {
			long base = 1;
			int subLen = arr[i].length();
			for (int j = subLen - 1; j >= 0; j--, base *= 10) {
				//make the flag to weight
				int idx = arr[i].charAt(j) - 'A';
				if (j == 0) {
					//flag the first char cannot be 0
					tag[idx].flag = 1;
				}
				tag[idx].weight += base;
			}
		}
		//sort array by the weight
		Arrays.sort(tag, new Comparator<Element>() {
			//rewrite the compare to use in Element
			@Override
			public int compare(Element e1, Element e2) {
				return e1.weight > e2.weight ? 1 : (e1.weight == e2.weight ? 0 : -1);
			}
		});

		//if pre-arr exist,then convert the min weight zero
		if (tag[0].flag == 1) {
			int i = 0;
			for (; i < 10; i++) {
				if (tag[i].flag == 0)
					break;
			}
			Element tmp = tag[i];
			for (; i > 0; i--) {
				tag[i] = tag[i - 1];
			}
			tag[0] = tmp;
		}

		long sum = 0;
		for (int i = 9; i >= 0; i--) {
			sum += tag[i].weight * i;
		}
		return sum;
	}
}

class Element {
	long weight;
	int flag;
}