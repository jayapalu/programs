import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/13/18.
 */
public class FirstNonRepeatChar {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();
        System.out.println("Input string is " + str);

        firstNonRepeating(str);
    }

     static void firstNonRepeating(String str) {

        char[] ch = buidCharArray(str);

        for (int i =0; i< str.length(); i++) {
            if (ch[str.charAt(i)] == 1) {
                System.out.format(" \n###### first non repeating char = %c\n",str.charAt(i));
                break;
            }
        }
    }

   static char [] buidCharArray(String str) {

        char [] ch = new char[256];

        for (int i=0; i<str.length(); i++) {

            ch[str.charAt(i)]++;
        }
        return ch;
    }
}
