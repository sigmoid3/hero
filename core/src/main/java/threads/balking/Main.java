package alg2020.threads.balking;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        new DocumentEditThread("/Users/minqian/nnqs/hero/pattern/src/main/java/alg2020.str.threads/balking", "balking.txt").start();
    }
}