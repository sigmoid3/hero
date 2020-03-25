package threads.rwsplit;

import threads.rwsplit.solution.TablewarePair;

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
        new threads.rwsplit.solution.EatNoodleThread("C", tablewarePair).start();
        //        new EatNoodleThread("A", fork, knife).start();
        //        new EatNoodleThread("B", knife, fork).start();
    }
}
