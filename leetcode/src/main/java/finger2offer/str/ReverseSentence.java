package finger2offer.str;

public class ReverseSentence {
    public static void main(String[] args) {
        System.out.println(reverseSentence("student. a am I"));
    }

    private static String reverseSentence(String str) {
        String[] strArr = str.split(" ");
        if (strArr.length < 2) {
            return str;
        }
        String res = "";
        for (int i = strArr.length - 1; i >= 0; i--) {
            res = res + strArr[i] + " ";
        }
        String ret = res.substring(0, res.length() - 1);
        return ret;
    }
}