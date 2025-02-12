package lab1;

import java.math.BigInteger;

public class task6 {
    public static void main(String[] args) {
        BigInteger res = BigInteger.valueOf(1);

        for (int i = 1; i < 1001; i++) res = res.multiply(BigInteger.valueOf(2));

        System.out.println(res);
    }
}
