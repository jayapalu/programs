package javaconcept;


import java.math.BigInteger;
import java.util.*;

class Priorities{

    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<Student>(events.size(), new StudentComparator());

        List<Student> ss = new LinkedList<Student>();
        for(String event: events){
            String[] input = event.split(" ");

            if(input[0].equals("ENTER")){
                pq.add(new Student(input[1], Double.parseDouble(input[2]), Integer.parseInt(input[3])));
            } else if(input[0].equals("SERVED")){
                pq.poll();
            }
        }

        while (!pq.isEmpty()){
            ss.add(pq.poll());
        }
        return ss;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() < s2.getCgpa()) {
            return 1;
        }
        else if (s1.getCgpa() > s2.getCgpa()) {
            return -1;
        }else if(s1.getName().compareTo(s2.getName()) == 0){
            return (s2.getId() -  s1.getId());
        }else{
            return s1.getName().compareTo(s2.getName());
        }
    }
}


public class PriorityQueueEx {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
