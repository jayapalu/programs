package javaconcept;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/6/17.
 */
public class StrReverse {

    public static void main (String [] args) {

        Scanner sc  =new  Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        StringBuilder s1 = new StringBuilder();

        //sb.append(sc.next());
        String str = sc.next();
        //System.out.println("entered str is: "+sb);

        char[] ch = str.toCharArray();

        int j=ch.length;
        for (int i=0; i<ch.length; i++) {

            char c = ch[i];
            ch [i] = ch[ch.length-i-1];
            ch[ch.length-i-1]=c;
            j--;
            System.out.print(ch[ch.length-i-1]);

            if (i >= j) {
                break;
            }
        }

        System.out.println(Arrays.toString(ch));


    }
}
