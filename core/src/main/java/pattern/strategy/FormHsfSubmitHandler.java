package pattern.strategy;

import java.io.Serializable;

/**
 * @author: minqian
 * @since: 2020/11/29
 * @description:
 */
public class FormHsfSubmitHandler implements FormSubmitHandler<Serializable> {

    @Override
    public String getSubmitType() {
        return "hsf";
    }

    @Override
    public Object handleSubmit(String request) {
        return "success";
    }
}
