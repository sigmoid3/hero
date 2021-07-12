package threads.latch;

/**
 * @Author: minqian
 * @Create: 2020/3/29
 * @Description:
 **/
public class WaitTimeoutException extends Exception {
    public WaitTimeoutException(String message) {
        super(message);
    }
}