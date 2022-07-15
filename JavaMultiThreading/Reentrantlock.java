import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


class Sample {

    int x;

    ReadWriteLock rwLock = new ReentrantReadWriteLock();

    Sample(int xval) {
        this.x = xval;
    }

    int getX() {
        return this.x;
    }

    void setX(int x) {
        this.x = x;
    }

    void increment() {

        Lock writelock = rwLock.writeLock();

        try {
            writelock.lock();
            System.out.println("Lock acquired .. incrementing x =" + this.x);

            int y = getX();
             y++;
            setX(y);

        }finally {
            writelock.unlock();
        }
    }


}

class MyThread extends  Thread {

    Sample sample;

    MyThread(Sample sample) {
        this.sample = sample;
    }

    @Override
    public void run() {
        sample.increment();
    }
}

public class Reentrantlock {

    public static void main(String[] args) {

        Sample sample = new Sample(10);
        MyThread t1 = new MyThread(sample);

        MyThread t2 = new MyThread(sample);

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println(sample.getX());
    }
}

