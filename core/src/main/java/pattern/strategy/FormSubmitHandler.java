package pattern.strategy;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: minqian
 * @since: 2020/11/29
 * @description:
 */
public interface FormSubmitHandler<R extends Serializable> {
    String getSubmitType();

    Object handleSubmit(String request);
}
