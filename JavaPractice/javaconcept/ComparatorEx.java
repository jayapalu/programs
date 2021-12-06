//package javaconcept;

import java.util.*;

class Student1{
    private int id;
    private String fname;
    private double cgpa;
    public Student1(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
}

public class ComparatorEx {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<Student1> studentList = new ArrayList<Student1>();
        while(testCases>0){
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            Student1 st = new Student1(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList, new Comparator<Student1>(){
            @Override
            public int compare(Student1 s1, Student1 s2){
                if(s1.getCgpa()*1000 > s2.getCgpa()*1000){
                    return -1;
                }else if(s1.getCgpa()*1000 < s2.getCgpa()*1000){
                    return 1;
                }else if(s1.getFname().compareTo(s2.getFname()) == 0){
                    return (s2.getId() -  s1.getId());
                }else{
                    return s2.getFname().compareTo(s1.getFname());
                }
            }});


        for(Student1 st: studentList){
            System.out.println(st.getFname());
        }

    }//main


}
