import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FilesEx {

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.lines(Paths.get("/Users/jayapal/dev/github/programs/JavaPractice/springpractice/pom.xml"))
                .filter(line -> line.contains("artifactId"))
                .map(line->line.replaceAll("artifactId", "")
                        .replaceAll("/", "")
                        .replaceAll("<", "")
                        .replaceAll(">", ""))
                .collect(Collectors.toList());
        System.out.println(lines);


    }
}
