import javax.security.sasl.SaslServer;

class A12 {

    int i;

    A12() {
        System.out.println("A12");

    }

    void display() {
        System.out.println(" parent i = "+i);

    }
}

 class B1 extends A12 {

    int j;

    B1() {
        System.out.println("B1");

    }
    void display() {
        System.out.println(" child j = "+j);
    }

}


class Inheritance1 {

    public static void main(String[] args) {

//        A12 obj = new B1();
//        obj.i = 1;
//        obj.j = 2;

        //A12 obj1 = new B1();;

    }

}