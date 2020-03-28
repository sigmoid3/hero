package threads.deadlock;

/**
 * @Author: minqian
 * @Create: 2020/3/26
 * @Description: 哲学家吃面问题
 **/
public class Tableware {
    private final String toolName;

    public Tableware(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String toString() {
        return "Tool:" + toolName;
    }
}
