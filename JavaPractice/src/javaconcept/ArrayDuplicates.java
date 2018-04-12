package javaconcept;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by jayapal_uradi on 4/7/17.
 */
public class ArrayDuplicates {

    public static void main(String [] args) {

        String[] array = {"one", "two", "three", "three"};

        System.out.println(array.length);

        for (int i=0; i<array.length-1; i++) {
            for (int j=i+1; j<array.length; j++) {

                if (array[i].equals(array[j])) {
                    System.out.println("Duplicate:"+array[j]);
                }
            }
        }

        detectduplicates(array);
    }

    static void detectduplicates (String [] array) {
        HashSet<String> set = new HashSet<String>();
        for (String str: array) {

            if (!set.add(str)) {
                System.out.println("Duplicate string "+str);
            }

        }

    }
}
