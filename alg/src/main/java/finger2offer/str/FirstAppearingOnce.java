package finger2offer.str;

public class FirstAppearingOnce {
    static int[] stream = new int[256];
    static StringBuffer str = new StringBuffer();

    // Insert one char from stringstream
    public static void insert(char ch) {
        str.append(ch);
        if (stream[ch] == 0) {
            stream[ch] = 1;
        } else {
            stream[ch] += 1;
        }
    }

    // return the first appearence once char in current stringstream
    public static char firstAppearingOnce() {
        char[] charArr = str.toString().toCharArray();
        for (char val : charArr) {
            if (stream[val] == 1) {
                return val;
            }
        }
        return '#';
    }
}