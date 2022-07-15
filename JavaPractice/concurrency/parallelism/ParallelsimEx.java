import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelsimEx {

    public static void main(String[] args) {

        List<String> list = List.of("Jayapal","Reddy","Uradi","Hyd");
                //new ArrayList<>();
        System.out.println("Availabe processors are "+Runtime.getRuntime().availableProcessors());
        System.out.println(list);

        List<String> upperCaseList = list.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("upper case "+upperCaseList );


    }
}
