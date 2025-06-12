package lab4.task13_from_list;

import java.lang.reflect.*;


public class ProxyLogger {
    @SuppressWarnings("unchecked")
    public static <T> T proxyLog(Class<T> cl) throws Exception {
        T realObject = cl.getDeclaredConstructor().newInstance();

        Class<?>[] interfaces = cl.getInterfaces();
        if (interfaces.length == 0) {
            throw new IllegalArgumentException("Class " + cl.getName() + " does not implement any interfaces");
        }

        return (T) Proxy.newProxyInstance(
                cl.getClassLoader(),
                interfaces,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        int mods = method.getModifiers();
                        System.out.println("Calling method: " + method.getName());
                        System.out.println("Modifiers: " + Modifier.toString(mods));
                        if (args == null || args.length == 0) {
                            System.out.println("No arguments");
                        } else {
                            System.out.print("Arguments: ");
                            boolean isFirst = true;
                            for (Object arg : args) {
                                if (!isFirst)
                                    System.out.print(", ");
                                else
                                    isFirst = false;

                                System.out.print(arg);
                            }
                            System.out.println();
                        }
                        return method.invoke(realObject, args);
                    }
                });
    }
}
