package threads.rwsplit;

/**
 * @Author: minqian
 * @Create: 2020/3/26
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleThread("A", fork, knife).start();
        new EatNoodleThread("B", knife, fork).start();
    }
}
