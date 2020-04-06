package old.str;

public class MultiPlus {
	public static void main(String[] args) {
		String str1 = "100";
		String str2 = "9999999999999999999999999999";
		MultiPlus sol = new MultiPlus();
		String ret = sol.multiply(str1, str2);
		System.out.println(ret);
	}
	public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();

        int[] result = new int[chars1.length + chars2.length];
        int[] n1 = new int[chars1.length];
        int[] n2 = new int[chars2.length];

        for (int i = 0; i < chars1.length; i++)
            n1[i] = chars1[i] - '0';
        for (int i = 0; i < chars2.length; i++)
            n2[i] = chars2[i] - '0';

        //AB*CD = AC(BC+AD)BD
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                result[i + j] += n1[i] * n2[j];
			}
		}

		//larger than 10 need to add on high index
		for (int i = result.length - 1; i > 0 ; i--) {
			result[i - 1] += result[i] / 10;
			result[i] = result[i] % 10;
		}

		//transfer to String
		String ret = "";
		for (int i = 0; i < result.length - 1; i++) {
			ret += "" + result[i];
		}
		return ret;
	}
}