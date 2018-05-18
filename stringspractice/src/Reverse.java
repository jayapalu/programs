import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/12/18.
 */
public class Reverse {

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        System.out.println("Input string is " + str);

        char [] ch = str.toCharArray();
        int len = str.length();
        len --;
        for (int i = 0; i< str.length(); i++) {
            char temp = ch[i];
            ch[i] = ch[len];
            ch[len] = temp;
            len--;

            if (i >= len) {
                break;
            }
        }
        System.out.println(ch);
        System.out.println("string after reverse " + ch);
        System.out.println("string after reverse " + Arrays.toString(ch));
    }
}
