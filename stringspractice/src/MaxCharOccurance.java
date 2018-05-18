import java.lang.Character;
import java.lang.Integer;
import java.lang.System;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by jayapal_uradi on 4/11/18.
 */
public class MaxCharOccurance {


        public static void main(String[]args){


            //BufferedInputStream s = new BufferedInputStream()
            //String name = System.console().readLine();
            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // Reading data using readLine
            //String name = reader.readLine();

            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();

            scanner.close();

            System.out.println("Input string is "+ str);

            //print chars in the string

            HashMap<Character, Integer> charNumber = new HashMap<Character, Integer>();

            for (int i=0; i<str.length(); i++ ) {
                System.out.println("Input string is "+ str.charAt(i));
                Character c = str.charAt(i);

                if (charNumber.containsKey(c)) {
                    System.out.format("Char found in map %c %d \n", c, charNumber.get(c) );
                    charNumber.put(c,charNumber.get(c)+1);
                } else {
                    charNumber.put(c,1);
                }
            }

            Collection<Character> col = charNumber.keySet();

            int max = 0;
            Character maxChar = null;// Character.MIN_VALUE;
            for (Iterator i = col.iterator(); i.hasNext();) {
                Character ch = (Character)i.next();
                int count = charNumber.get(ch);
                System.out.format("The key:value is %c:%d \n", ch,count);

                if (count > max) {
                    max = count;
                    maxChar = ch;
                }
            }

            System.out.format("The max occur key:value is %c:%d \n", maxChar,max);




        }
}

