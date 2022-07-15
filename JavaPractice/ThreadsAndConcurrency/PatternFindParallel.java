import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

import com.example.io.utils.*;

public class PatternFindParallel {

    public static void main(String[] args) throws IOException {

        String pattern = "public";
        File dir = new File("programs/JavaPractice/ThreadsAndConcurrency/");
        File[] files = dir.listFiles();

        PatternFindInFiles finder = new PatternFindInFiles();

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        //executorService.shutdown();

        Map<String, Object> map = new HashMap<>();

        Long starttime = System.currentTimeMillis();

        for (File f : files) {
            System.out.println(" file name: " + f.getPath());

            Future<List<Integer>> future = executorService.submit(new Callable<List<Integer>>() {
                @Override
                public List<Integer> call() throws Exception {
                    List<Integer> list = finder.find(f.getPath(), pattern);
                    return list;
                }
            });

            map.put(f.getName(), future);
        }

        funWaitForAll(map);

        for(Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(pattern + " found at  " + entry.getValue() + " in file "+ entry.getKey());
        }

        System.out.println(" Execution time = " + (System.currentTimeMillis() - starttime));
    }

    private static void funWaitForAll(Map<String, Object> resultMap) {

        Set<String> keys =  resultMap.keySet();

        for(String key : keys) {

            Future<List<Integer>> future = (Future<List<Integer>>) resultMap.get(key);

            while(!future.isDone()) {
                //idle
            }

            try {
                resultMap.put(key, future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


    }


}
