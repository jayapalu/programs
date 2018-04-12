/**
 * Created by jayapal_uradi on 2/19/17.
 */
class A {

    static {
        System.out.println("This is static initialization");
    }

    {
        System.out.println("This is instance initialization");
    }

    A() {
        System.out.println("This is class A constructor");
    }
}

class B extends A {
    int j;
}


public class InheritanceSIB {
    public static void main (String[] args) {
        B b = new B();
        //Output: This is static initialization
        //This is instance initialization
        //This is class A constructor

        //A a = new A();
    }
}
