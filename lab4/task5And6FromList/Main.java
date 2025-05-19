package lab4.task5And6FromList;


public class Main {
    public static void main(String[] args) {
        int s1 = Constants.STATUS_ACTIVE;
        System.out.println(s1);
        // Можно передать любое число, даже если оно не является статусом
        s1 = 999;
        System.out.println(s1);

        Status s2 = Status.ACTIVE;
        System.out.println(s2);
        // s2 = 999;
        // Компилятор проверяет, что передаётся только Status, а не случайное число

        Color c = Color.RED;
        System.out.println(c.getHexCode() +  " is " + c.getName());

        switch (c) {
            case RED:
                System.out.println("it's red!");
                break;
            case GREEN:
                System.out.println("it's green!");
                break;
        }
    }
}
