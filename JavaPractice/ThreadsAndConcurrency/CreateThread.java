
class myThread extends  Thread {

    @Override
    public void run() {

        System.out.println("This is my thread .... extended from Thread class");
        for(int i=0;i<1000; i++) {
            System.out.print("T");
        }


    }
}

class myThreadRunnable implements Runnable {


    @Override
    public void run() {
        System.out.println("This is runnable thread");

        for(int i=0; i<1000; i++) {
            System.out.print("R");
        }
    }
}


public class CreateThread {
    public static void main(String[] args) {

        myThread t1 = new myThread();
       // t1.start();

        Thread t2 = new Thread(new myThreadRunnable());
        t2.start();


        for(int i=0;i<1000; i++) {
            System.out.print("M");
        }

    }
}