import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MaptoInit {


    public static void main(String[] args) {

        List<String> list = Arrays.asList("Jayapal", "Ram", "krishna", "Hari");

        System.out.println("This is with imperative style");
        for (String name : list) {
            if (!name.equals("Ram")) {
                StreamsMapperEx.User user = new StreamsMapperEx.User(name);
                System.out.println(user);
            }
        }
        //list.stream().collect(Collectors.;

        System.out.println();
        System.out.println("This is with functional Style");
        System.out.println();
        list.stream().filter(name -> !name.equals("Ram"))
                .map(name -> new StreamsMapperEx.User(name))
                .forEach(name -> System.out.println(name));


        System.out.println();
        System.out.println();

        System.out.println(" Map to int example");
        List<User> users = list.stream().filter(name -> !name.equals("Ram"))
                .map(name -> new User(name))
                .collect(Collectors.toList());

        int ageSum = users.stream().mapToInt(user -> user.age).sum();
        System.out.println("Age sum = "+ageSum);

    }

    public static class User {

        String name;
        int age = 12;

        public User(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return "Name: "+name +" age : "+age;
        }
    }


}
