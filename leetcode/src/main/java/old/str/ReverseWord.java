package old.str;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWord {
	public static void main(String[] args) {
		ReverseWord rw = new ReverseWord();
		String str = "  the    sky is blue ";
		System.out.println(rw.reverseWords(str));
	}
	public String reverseWords(String s) {
		//" +" is the special usage for words
		String[] words = s.trim().split(" +");
		//turn the string[] into asList
		Collections.reverse(Arrays.asList(words));
		//join the words
		return String.join(" ", words);
	}
}