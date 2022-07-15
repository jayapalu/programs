import java.io.File;
import java.io.IOException;
import java.util.List;

import com.example.io.utils.*;

public class PatternFindSeral {

    public static void main(String[] args) throws IOException {

        String pattern = "public";
        File dir = new File("programs/JavaPractice/ThreadsAndConcurrency/");
        File[] files = dir.listFiles();

        PatternFindInFiles finder = new PatternFindInFiles();

        Long starttime = System.currentTimeMillis();
        for( File f : files) {
            System.out.println(" file name: "+f.getPath());
           List<Integer> list = finder.find(f.getPath(), pattern);
           System.out.println(list);
        }

        System.out.println(" Execution time = " + (System.currentTimeMillis() - starttime));
    }

}
