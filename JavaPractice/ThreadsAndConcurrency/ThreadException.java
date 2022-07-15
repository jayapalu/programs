
class ThreadExc extends  Thread {

    @Override
    public void run() {

        System.out.println("Running thread "+Thread.currentThread().getName());
        for(int i=0;i<10; i++) {
            System.out.print("T");
        }

        throw new RuntimeException(" Run time error thrown");
    }
}


public class ThreadException {
    public static void main(String[] args) {

        ThreadExc t1 = new ThreadExc();
        t1.setName("Thread-1");

        for(int i=0;i<5; i++) {
            System.out.print("M");
        }

        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(" In thread "+ t.getName() + " exception occured "+ e.getMessage());

            }
        });

        t1.start(); //

    }
}