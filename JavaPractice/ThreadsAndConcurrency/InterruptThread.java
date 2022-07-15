
class myThreadInt extends Thread {

    @Override
    public void run() {

        while(true) {
            if (interrupted()) {
                System.out.println("Thread is interrupted ####");
                break;
            }
            System.out.print("T");
        }
    }
}

public class InterruptThread {

    public static void main(String[] args) {

        myThreadInt t1 = new myThreadInt();
        t1.start();
        for(int i=0; i<10; i++) {
            System.out.print("M");
        }
        System.out.println();
        t1.interrupt();

    }
}
