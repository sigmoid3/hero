package old.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: sandro
 * @Create: 2019-09-20
 * @Description:
 **/
public class GenerateaPossibleNextMove {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> ret = new ArrayList<>();
        if (!s.contains("++")) {
            return ret;
        }
        int len = s.length() - 1;
        for (int i = 0; i < len; i++) {
            if (s.substring(i, i + 2).equals("++")) {
                ret.add(s.substring(0, i) + "--" + s.substring(i + 2, len + 1));
            }
        }
        return ret;
    }
}
