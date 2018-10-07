
public class StaticOverride {

    static void test() {
        System.out.println("This is static method with no arguments");
    }

    static void test(int i) {
        System.out.println("This is static method with one arg i = "+i);
    }

    public static void main(String args[]) {

        StaticOverride a = new StaticOverride();

        StaticOverride.test();
        StaticOverride.test(10);
    }

}

 class base {

       static void display() {
        System.out.println("This is base class static method");
    }
}

class derived extends  base {
     static void display() {
        System.out.println("This is derived class static method");
    }
}