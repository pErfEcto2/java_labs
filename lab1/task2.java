package lab1;



public class task2 {
    public static void main(String[] args) {
        int a = Integer.parseInt(System.console().readLine());
        System.out.println(Math.floorMod(a, 360));
        while (a < 0) {
            a += 360;
        }
        System.out.println(a % 360);
    }

}
