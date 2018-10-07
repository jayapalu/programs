package javaconcept;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student {
    private String name;
    private int id;
    private double cgpa;
    private String email;

    Student(String name,  double cgpa, int id){
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class Reflection {


    public static void main(String[] args){
        Class student=Student.class;
        Method[] methods = student.getDeclaredMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m : methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
