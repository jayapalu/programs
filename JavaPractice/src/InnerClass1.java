/**
 * Created by jayapal_uradi on 3/1/17.
 */


class OuterClass {

    OuterClass() {
        System.out.println("This is from outer class constructor ");
    }

    void methodOne() {
        System.out.println("This is from methodone outerclass ");
    }

    class InnerClass {

        InnerClass() {
            System.out.println("This is from inner class constructor");
        }

         void methodOne() {
            System.out.println("This is from methodone inner class");

        }
    }
}

public class InnerClass1 {

    public static void main(String [] args) {

        OuterClass o1 = new OuterClass();
        o1.methodOne();

        OuterClass.InnerClass i1 = o1.new InnerClass();
        i1.methodOne();
    }

}
