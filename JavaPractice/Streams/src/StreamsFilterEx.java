import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StreamsFilterEx {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Jayapal", "Ram", "krishna", "Hari");

        list.stream().filter(name -> !name.equals("Ram"))
                .forEach(name -> System.out.println(name));


        System.out.println("This is with method reference");
        list.stream().filter(name -> !name.equals("Ram"))
                .forEach(System.out::println);


        Random random = new Random();
        random.ints().limit(5).forEach(System.out::println);


    }
}
