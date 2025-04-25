package lab3;

interface IntSequence {
    int next();
    default boolean hasNext() {
        return true;
    }

    static IntSequence of(int... values) {
        return new IntSequence() {
            private int index = 0;

            @Override
            public int next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No elements left");
                }
                return values[index++];
            }

            @Override
            public boolean hasNext() {
                return index < values.length;
            }
        };
    }

    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int next() {
                return value;
            }
        };
    }

    static IntSequence constant2(int value) {
        return () -> value;
    }
}

class task4_and_5 {
    public static void main(String[] args) {
        IntSequence s1 = IntSequence.of(1, 2, 3, 4, 5);
        IntSequence s2 = IntSequence.constant(42);
        IntSequence s3 = IntSequence.constant2(42);

        while (s1.hasNext()) {
            System.out.println("First sequence: " + s1.next() + "; second: " + s2.next() + "; third: " + s3.next());
        }
    }
}