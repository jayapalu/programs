
class myRunnable1 implements Runnable {

    @Override
    public void run() {
        System.out.println("This is runnable thread");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

public class ThreadGroupEx {

    public static void main(String[] args) {



        //new Thread(() -> System.out.println(" Runnable thread"), "Mythread1").start();
        Thread t2 = new Thread( new myRunnable1(), "Thread2");
        t2.start();

        Thread t1 = Thread.currentThread();
        ThreadGroup tg = t1.getThreadGroup();
        while(tg.getParent() != null) {
            tg = tg.getParent();

        }
        tg.list();
    }
}
