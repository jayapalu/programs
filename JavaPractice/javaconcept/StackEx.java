package javaconcept;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackEx {
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input=sc.next();

            if(input.isEmpty()){
                System.out.println("true");
                continue;
            }

            char [] ch = input.toCharArray();
            if(validateExpn(ch)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }//main

    static boolean validateExpn(char[] ch) {

        Stack<Character> stack = new Stack<>();
        int i = 0;
        Character[] openArray = {'{', '(', '['};
        Character[] closeArray = {'}', ')', ']'};

        ArrayList<Character> list1 = new ArrayList<Character>();
        ArrayList<Character> list2 = new ArrayList<Character>();

        list1.add('{');
        list1.add('(');
        list1.add('[');

        list2.add('}');
        list2.add(')');
        list2.add(']');

        while (i < ch.length) {
            if (!stack.empty()) {
                Character peek = stack.peek();
                if (list1.indexOf(peek) != -1 &&  list1.indexOf(peek) == list2.indexOf(ch[i])) {
                    stack.pop();
                }else{
                    stack.push(ch[i]);
                }
            } else {
                stack.push(ch[i]);
            }
            i++;
        }//while

        return stack.isEmpty();
    }
}
