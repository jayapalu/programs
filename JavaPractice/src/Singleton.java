/**
 * Created by jayapal_uradi on 2/24/17.
 */

class mysingleton {
    static mysingleton instance = null;
    public int x = 10;

    //private constructor can't be accessed outside the class
    private mysingleton() {

    }

    static public mysingleton getInstance() {
        if (instance == null) {
            instance = new mysingleton();
        }
        return  instance;
    }
}
public class Singleton {
    public static void main(String args[]) {
       // mysingleton m = new mysingleton(); this gives error because mysingleton has private class
        mysingleton a = mysingleton.getInstance();
        mysingleton b = mysingleton.getInstance();

        a.x = a.x + 10;

        System.out.println("value of a.x = " + a.x);
        System.out.println("value of b.x="+b.x);
    }
}
