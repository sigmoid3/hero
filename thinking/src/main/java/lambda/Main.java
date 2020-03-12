package lambda;

/**
 * @Author: sandro
 * @Create: 2019-09-05
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
        WorkerImpl.execute(new Worker() {
            @Override
            public void work() {
                System.out.println("this is working");
            }
        });
    }
}
