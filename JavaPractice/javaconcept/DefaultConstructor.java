/**
 * Created by jayapal_uradi on 2/19/17.
 */

 class superClass{

    int i;

    superClass(int i) {
        this.i = i;
        System.out.println("class A constructor with one arg");
    }

}

class subClass extends superClass {

    int j;

    public subClass() {
        super(10);
        System.out.println("This is subclass constructor");
    }

}
public class DefaultConstructor {
}
