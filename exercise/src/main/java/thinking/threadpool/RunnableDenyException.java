package thinking.threadpool;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}