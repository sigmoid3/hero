package algorithm.others;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class TinyUrlSolution3 {
    Map<Integer, String> map = new HashMap<>();
    /*
     * //通过数组索引实现 int i = 0; public String encode(String longUrl) { map.put(i,
     * longUrl); //存入一个map return "http://tinyurl.com/" + i++; } public String
     * decode(String shortUrl) { return
     * map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""))); }
     */

    /*
     * //通过hash索引Kv实现 public String encode(String longurl){
     * map.put(longurl.hashCode(),longurl); //hash处理 return
     * "http://tinyurl.com/"+longurl.hashCode(); } public String decode(String
     * shorturl){ return
     * map.get(Integer.parseInt(shorturl.replace("http://tinyurl.com/",""))); }
     */

    // 通过random随机数
    Random r = new Random();
    int key = r.nextInt(10000);

    public String encode(String longurl) {
        while (map.containsKey(key)){
            key = r.nextInt(10000);
            map.put(key, longurl);
        }
        return "http://tinyurl.com/" + key;
    }

    public String decode(String shorturl) {
        return map.get(Integer.parseInt(shorturl.replace("http://tinyurl.com/", "")));
    }
}

public class TinyUrl {
    public static void main(String[] args) {
        TinyUrlSolution3 sol = new TinyUrlSolution3();
        Scanner s = new Scanner(System.in);
        String str1 = s.next();
        System.out.println(sol.encode(str1));
        String str2 = s.next();
        System.out.println(sol.decode(str2));
    }

}
