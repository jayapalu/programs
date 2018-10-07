package javaconcept;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashEx {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    int t = s.nextInt();
    String [] pair_left = new String[t];
    String [] pair_right = new String[t];

    for(int i=0; i<t; i++){
        pair_left[i] = s.next();
        pair_right[i] = s.next();
    }


    Set<String> s1 = new HashSet<String>();
    Set<String> s2 = new HashSet<String>();

    for(int i=0;i<t;i++){
        s1.add(pair_left[i]);
        s2.add(pair_right[i]);

        if(s1.size()> s2.size()){
            System.out.println(s1.size());
        }else{
            System.out.println(s2.size());
        }
    }

    }//main
}//class
