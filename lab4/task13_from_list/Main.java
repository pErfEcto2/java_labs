package lab4.task13_from_list;


public class Main {
    public static void main(String[] args) throws Exception {
        Calculator calculatorProxy = ProxyLogger.proxyLog(CalculatorImpl.class);

        int sum = calculatorProxy.add(5, 3);
        System.out.println("Result of add: " + sum + "\n");

        int product = calculatorProxy.multiply(4, 7);
        System.out.println("Result of multiply: " + product);
    }
}
