package old.str;

public class AddString {

	public String addString(String num1, String num2) {
		if (num1.equals("0")) {
			return num2;
		}
		if (num2.equals("0")) {
			return num1;
		}
		int len1 = num1.length();
		int len2 = num2.length();
		int len = Math.max(len1, len2);

		char[] result = new char[len + 1];
		for (int k = 0; k < len + 1; k++) {
			result[k] = '0';
		}

		int p = 0, X = 0, Y = 0;
		for (int i = 0; i < len + 1; i++) {
			if (i < len1) {
				X = num1.charAt(len1 - i - 1) - '0';
			} else {
				X = 0;
			}
			if (i < len2) {
				Y = num2.charAt(len2 - 1 - i) - '0';
			} else {
				Y = 0;
			}

			int temp = X + Y + p;
			result[len - i] = (char) (temp % 10 + '0');
			p = temp / 10;
		}
		int count = 0;
		for (; count < len + 1; count++) {
			if (result[count] != '0') {
				break;
			}
		}

		String res = "";
		for (int i = count; i < len + 1; i++) {
			res += result[i];
		}

		return res;
	}
}
