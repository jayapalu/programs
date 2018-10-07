import java.lang.Override;

class A1 {
        @Override
        protected void finalize() throws Throwable {
        System.out.println("finalize method is called");
        }
        }

public class Gc {
    public static void main (String[] args) {

        A1 a = new A1();
        A1 b = new A1();
        a = b;
        System.gc();
        System.out.println("Done ...");
    }
}