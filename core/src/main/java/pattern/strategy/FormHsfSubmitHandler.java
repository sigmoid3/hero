package pattern.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author: minqian
 * @since: 2020/11/29
 * @description:
 */
public class FormHsfSubmitHandler implements FormSubmitHandler<Serializable> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String getSubmitType() {
        return "hsf";
    }

    @Override
    public Object handleSubmit(String request) {
        logger.info(this.getSubmitType() + "模式提交：userId={}, formInput={}" + request);
        return "success";
    }
}
