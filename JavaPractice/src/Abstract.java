/**
 * Created by jayapal_uradi on 2/26/17.
 */

abstract  class AbstractClass{
    abstract void abstractMethod();
    {
        System.out.println("Instance initialization block");
    }

    static {
        System.out.println("static IB");
    }
}


interface X
{
    void methodX();
}

class Y implements X
{
    public void methodX() // byd default it is default. It should made public.
    {
        System.out.println("Method X");
    }
}

class ConcreteClass { //extends  AbstractClass {

    //@Override
    void abstractMethod() {
        System.out.println(" Hi from abstract method implementation");
    }
}

public class Abstract {

    public static void main(String[] args) {
        ConcreteClass c = new ConcreteClass();
        c.abstractMethod();
    }
}
