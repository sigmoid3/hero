package old.str;//jinri offer1.4 2017 backend
import java.util.*;
public class KthBit {
	public static void main(String[] args) {
		long x;
		int k;
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			x = scan.nextLong();
			k = scan.nextInt();
			long i = 0;
			List<Long> list = new ArrayList<Long>();
			while (i <= x) {
				if ((x + i) == (x | i))
					list.add(i);
				i++;
			}
			Collections.sort(list, new Comparator<Long>() {
				@Override
				public int compare(Long a, Long b) {
					return a < b ? 1 : 0;
				}
			});
			System.out.println(list.get(k));
		}
		scan.close();
	}
}