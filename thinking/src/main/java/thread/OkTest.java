package thread;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Sandro
 * @Create: 2019-08-14 15:13
 * @Info:
 **/
public class OkTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+entry.getValue());
        }
    }

}
