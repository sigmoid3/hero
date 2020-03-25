package threads.rwsplit.solution;

/**
 * @Author: minqian
 * @Create: 2020/3/26
 * @Description:
 **/
public class EatNoodleThread extends Thread {
    private final String name;
    private final TablewarePair tablewarePair;

    public EatNoodleThread(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool());
            System.out.println(name + " take up " + tablewarePair.getRightTool());
            System.out.println(name + " is eating now.");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }
}
