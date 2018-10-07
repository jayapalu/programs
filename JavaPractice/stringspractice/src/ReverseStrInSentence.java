import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/13/18.
 */
public class ReverseStrInSentence {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        StringBuilder sb = new StringBuilder(str);
        System.out.println("Input string is " + str);

        String [] strArr = str.split(" ");

        System.out.println("Input string is " + Arrays.toString(strArr));
        //https://www.geeksforgeeks.org/g-fact-27-string-vs-stringbuilder-vs-stringbuffer/
        StringBuffer str1 = new StringBuffer();

        for (int i =0; i< strArr.length ; i++) {
            StringBuffer str2 = new StringBuffer(strArr[i]);
            str1.append(str2.reverse());
        }
        System.out.println("Reverse of the string is " + strArr);

        if (strArr.length == 1) {
            for (int i =0 ; i< strArr[0].length(); i++) {
                System.out.format("%c ", strArr[0].charAt(i));
            }
        }


        int s=0,e=0;
        boolean spaceSeen = false;

        for (int i=0; i<str.length(); i++) {

            if (str.charAt(i) != ' ') {

                if ( spaceSeen == true) {
                    s++;
                }
                spaceSeen = false;
                e++;
                continue;
            } else {

                if ( spaceSeen == true) {
                    e++;
                    s=e;
                    continue;
                }
                strRever(sb, s, e);
                spaceSeen = true;
                s=e;
            }
        }
        // for the last string in sentence to reverse
        strRever(sb, s, e);


        System.out.println("Reverse of the string is " + sb);
    }

    static void strRever(StringBuilder str, int s, int e) {

        while (s <= e) {
            char ch = str.charAt(s);
            str.setCharAt(s, str.charAt(e));
            str.setCharAt(e, ch);
            s++;
            e--;
        }

        System.out.println(" Sb reverse " + str);
    }



}
