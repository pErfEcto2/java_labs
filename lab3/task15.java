package lab3;


import java.util.Random;

class RandomIntSequence {
    private static Random generator = new Random();

    private static class RandomSequence implements IntSequence {
        private int low;
        private int high;

        public RandomSequence(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }

        @Override
        public boolean hasNext() {
            return true;
        }
    }

    public static IntSequence randomInts(int low, int high) {
        return new RandomSequence(low, high);
    }
}

public class task15 {
    public static void main(String[] args) {
        IntSequence r = RandomIntSequence.randomInts(1, 10);

        for (int i = 0; i < 5; i++)
            System.out.println("Next random int is: " + r.next());
    }
}
