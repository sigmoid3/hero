package old.str;
import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if (n == 0){
            list.add(0);
        }
        else {
            list.add(0);
            list.add(1);
            for (int i = 1; i < n; i++) {
                int len = list.size();
                double num = Math.pow(2, i);
                for (int idx = 0; idx < len; idx++) {
                    list.add((int) num + list.get(len - idx - 1));
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        GrayCode gc = new GrayCode();
        System.out.println(gc.grayCode(8));
    }
}