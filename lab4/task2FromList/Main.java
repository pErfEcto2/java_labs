package lab4.task2FromList;

class A {
    public void show() {
        System.out.println("A");
    }
}

class B extends A {
    @Override
    public void show() {
        System.out.println("B");
    }
}

class C extends A {
    @Override
    public void show() {
        System.out.println("C");
    }
}

// class D extends B, C {}
// which show to use?


interface X {
    default void show() {
        System.out.println("X");
    }
}

interface Y {
    default void show() {
        System.out.println("Y");
    }
}

class Z implements X, Y {
    @Override
    public void show() {
        X.super.show();
    }
}


public class Main {
    public static void main(String[] args) {
        Z obj = new Z();
        obj.show();
    }
}
