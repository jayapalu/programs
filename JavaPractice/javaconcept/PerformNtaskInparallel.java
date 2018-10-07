import com.sun.webkit.network.URLs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class PerformNtaskInparallel {

    public static final void main(String... aArgs) throws ExecutionException, InterruptedException {

        PerformNtaskInparallel checker = new PerformNtaskInparallel();
        System.out.println("Parallel, report each as it completes:");
        checker.pingReportEachWhenKnown();
        }


    public static List<String> URLs =Arrays.asList("http://www.youtube.com", "http://www.google.ca", "http://www.date4j.net", "http://www.web4j.com");

    public void pingReportEachWhenKnown() throws InterruptedException, ExecutionException {

        System.out.println("In pingReportEachWhenKnown");
        int numThreads = URLs.size() > 4 ? 4: URLs.size();

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CompletionService<PingResult> compService = new ExecutorCompletionService<>(executorService);

        for (String url : URLs) {
            Task task = new Task(url);
            System.out.println("Submitting task for url "+url);
            compService.submit(task);

        }

        for (String url : URLs) {
            Future<PingResult> f = compService.take();
            System.out.println("Getting result for task for url "+url);
            System.out.println(f.get());
        }

        executorService.shutdown();
    }


    public final class Task implements  Callable<PingResult> {

        private final String fURL;
        Task(String aUrl) {
            fURL = aUrl;
        }

        @Override
        public PingResult call () throws IOException, InterruptedException {
            return PingAndReportStatus(fURL);
        }
    }

        public PingResult PingAndReportStatus (String aURL) throws MalformedURLException, InterruptedException {

        PingResult result = new PingResult();

        result.URL = aURL;
        long start = System.currentTimeMillis();
        result.RESULT = false;

        URL url = new URL(aURL);

        try {
            URLConnection connection = url.openConnection();
            String firstline = connection.getHeaderField(0);
            long l = (long) (Math.random()*15);
            System.out.println("Ping done got first page and sleeping:"+ l  +" url "+ url);
            Thread.sleep(l);
            long end = System.currentTimeMillis();
            result.RESULT = true;
            result.TIMING = end - start;

            } catch (IOException e) {
                e.printStackTrace();
        }
        return result;
        }

    /** Simple struct to hold all the data related to a ping. */
    private static final class PingResult {
        String URL;
        Boolean RESULT;
        Long TIMING;

        @Override
        public String toString () {
            return "Result " +RESULT+" with timing " + TIMING + " URL "+URL ;
        }

    }

    }



