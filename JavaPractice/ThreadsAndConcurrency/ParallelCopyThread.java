import com.example.io.utils.*;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class copyTask implements Runnable {
    String sourceFile;
    String destFile;

    copyTask(String srcFile, String destFile) {
        this.sourceFile = srcFile;
        this.destFile = destFile;
    }

    @Override
    public void run () {

        try {
            System.out.println("copy started from thread");
            Ioutils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
public class ParallelCopyThread {

    public static void main(String[] args) {

        String current = null;
        try {
            current = new java.io.File( "." ).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Current dir:"+current);

        String inputfile1 = "programs/JavaPractice/ThreadsAndConcurrency/a.txt";
        String outputfile1 = "programs/JavaPractice/ThreadsAndConcurrency/b.txt";
        String outputfile2 = "programs/JavaPractice/ThreadsAndConcurrency/c.txt";


        Thread t1 = new Thread(new copyTask(inputfile1, outputfile1));
        t1.start();

        Thread t2 = new Thread(new copyTask(inputfile1, outputfile2));
        t2.start();

        System.out.println("Using executor service ############");
        ExecutorService executors = Executors.newFixedThreadPool(5);
        executors.submit(new copyTask(inputfile1, outputfile1));
        executors.submit(new copyTask(inputfile1, outputfile2));

        executors.shutdown();

        }
    }
