package finger2offer.str;

public class ReplaceSpace {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer(" We are Happy");
        System.out.println(replaceSpace1(str));
        System.out.println(replaceSpace2(str));
    }

    public static String replaceSpace1(StringBuffer str) {
        String ret = str.toString().replace(" ", "%20");
        return ret;
    }

    public static String replaceSpace2(StringBuffer str) {
        char[] arr = str.toString().toCharArray();
        int cntsp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                cntsp++;
            }
        }
        char[] newArr = new char[arr.length + 2 * cntsp];
        for (int i = 0, j = 0; i < arr.length; i++, j++) {
            if (arr[i] != ' ') {
                newArr[j] = arr[i];
            } else {
                newArr[j] = '%';
                newArr[j + 1] = '2';
                newArr[j + 2] = '0';
                j = j + 2;
            }
        }
        String ret = String.valueOf(newArr);
        return ret;
    }
    //若能动态分配数组内存，则可以从尾部使用双指针解决移位复杂性问题
}