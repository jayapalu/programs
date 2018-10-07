/**
 * Created by jayapal_uradi on 2/26/17.
 */

interface super1 {
    void display();
}

interface super2 extends super1{
    void display ();
}
public class TwoSuperClassSameMethods {
    public static void main (String[] args) {
        super2 s1 = new super2() {
            @Override
            public void display() {

            }
        };
        s1.display();
    }
}
