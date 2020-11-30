package pattern.strategy;

import java.io.Serializable;

/**
 * @author: minqian
 * @since: 2020/11/29
 * @description:
 */
public interface FormSubmitHandler<R extends Serializable> {
    String getSubmitType();

    Object handleSubmit(String request);
}
