package threads.deadlock.solution;

import threads.deadlock.Tableware;

/**
 * @Author: minqian
 * @Create: 2020/3/26
 * @Description:
 **/
public class TablewarePair {
    private final Tableware leftTool;
    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool) {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }

    public Tableware getLeftTool() {
        return leftTool;
    }

    public Tableware getRightTool() {
        return rightTool;
    }
}
