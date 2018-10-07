/**
 * Created by jayapal_uradi on 11/7/17.
 */
import java.lang.Runnable;

class myRunnable implements Runnable {

    public void run() {
        System.out.println("This is run method from the myRunnable class");
    }
}

class demo {

    public void concurrent() {
             for (int i = 1; i < 6; i++) {
                 System.out.println("Printing i="+i);

                 try
                 { Thread.sleep(500);

                 }catch(Exception e){System.out.println(e);
                 }
             }
    }
}

class threadDemo extends  Thread {
    demo d;
    threadDemo(demo d) {
        this.d = d;
    }
    @Override
    public void run() {
        System.out.println("This is inside the thread " + getName());
        d.concurrent();
    }
}


class threadDemo1 extends  Thread {
    demo d;
    threadDemo1(demo d) {
        this.d = d;
    }
    @Override
    public void run() {
        System.out.println("This is inside the thread "+getName());
        d.concurrent();
    }
}

public class RunnableExample {

    public static void main(String[] args) {
        threadDemo d = new threadDemo(new demo());
        d.start();

        threadDemo1 d1 = new threadDemo1(new demo());
        d1.start();
    }
}
