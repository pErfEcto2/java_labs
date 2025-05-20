package lab4.task9_from_list;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {
    private final Object target;

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("calling: " + method.getName());

        Object result = method.invoke(target, args);

        System.out.println("result: " + result);
        return result;
    }
}
