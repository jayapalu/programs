package javaconcept;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.*;

public class LinkedListEx {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n ; i++){
            int ele=scanner.nextInt();
            list.add(ele);
        }
        int op = scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<op ; i++){
            String ops = scanner.nextLine();
            System.out.println("ops = " + ops);
            if(ops.equals("Insert")){
                int index = scanner.nextInt();
                int ele = scanner.nextInt();
                list.add(index,ele);
            } else if (ops.equals("Delete")) {
                int index = scanner.nextInt();
                System.out.println("Remove ele at " + index);
                if(!list.isEmpty()) {
                    list.remove(index);
                }
            }
            scanner.nextLine();
            Map<String, Integer> map = new HashMap<String, Integer>();
        }
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}//class