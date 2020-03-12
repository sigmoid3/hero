package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: Sandro
 * @Create: 2019-06-20 15:07
 * @Info:
 **/
class PrivacyProxyInvocationHandler implements InvocationHandler {
    private Object proxyObj;

    public PrivacyProxyInvocationHandler(Object o) {
        proxyObj = o;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] arguments) throws Throwable {
        String methodName = "operation";
        if (object instanceof Account && method.getName().equals(methodName)) {
            PrivacyChecker.checkPrivacy();
        }
        return method.invoke(proxyObj, arguments);
    }
}

/**
 * @author Sandro
 */
public class AccountWithCheckerProxy {
    public static void main(String[] args) {
        Account account = (Account)Proxy.newProxyInstance(
            Account.class.getClassLoader(),
            new Class[] {Account.class},
            new PrivacyProxyInvocationHandler(new AccountImpl())
        );
        account.operation();
    }
}

