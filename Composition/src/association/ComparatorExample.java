package association;

/**
 * Created by jayapal_uradi on 4/20/18.
 */

class person implements Comparable {

    private String name;
    private int age;


    person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "association.person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object p) {

        person p1 = (person)p;

        if (this.age == p1.age ) {
            return 0;
        }
        return this.age > p1.age ? 1 : -1;
    }
}
public class ComparatorExample {

    public  static  void main (String args[]) {

        person p1 = new person("jayapal", 34);
        person p2 = new person("jay", 24);



        int ret = p1.compareTo(p2);

        switch (ret) {
            case 0:
                System.out.println(p1.getName() + " and p2 are of same age");
                break;
            case 1:
                System.out.println("p1 is older than p2 age");
                break;
            case -1:
                System.out.println("p1 is younger than p2 age");
            default:
                System.out.println("There is something wrong ");
        }
    }
}


