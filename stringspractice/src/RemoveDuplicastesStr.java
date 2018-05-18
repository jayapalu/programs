import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/12/18.
 * Write a program to remove all the duplicate characters from a given input String e.g. if given String is "Java" then output should be "Java". The second or further occurrence of duplicate should be removed.
 *  Read more: http://www.java67.com/2018/04/21-string-programming-and-coding-interview-questions-answers.html#ixzz5CR3KHSth
 */
public class RemoveDuplicastesStr {

    public static void main (String args[]) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        System.out.println("Input string is "+ str);

    }
}
