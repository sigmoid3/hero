package threads.deadlock;

import threads.deadlock.solution.EatNoodleThread;
import threads.deadlock.solution.TablewarePair;

/**
 * @Author: minqian
 * @Create: 2020/3/26
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        TablewarePair tablewarePair = new TablewarePair(fork, knife);
        new EatNoodleThread("C", tablewarePair).start();
        //        new EatNoodleThread("A", fork, knife).start();
        //        new EatNoodleThread("B", knife, fork).start();
    }
}
