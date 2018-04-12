package javaconcept;

/**
 * Created by jayapal_uradi on 4/7/17.
 */
public class RemoveWhiteSpace {

    public static void main(String[] args) {

        String str1 = "This is a    white   space string   ";
        //removewhiteSpace(str1);
        String str2 = "A2   JNTU College";

        String[] s = str2.split(" ");


        for (int i=0;i<s.length; i++) {

            System.out.println(s[i]);
        }
    }

    static void removewhiteSpace(String str1) {
        String strWithoutSpace  = str1.replaceAll("\\s","");
        System.out.println(strWithoutSpace);
        char[] chArray = str1.toCharArray();

        StringBuffer sb = new StringBuffer();

        for (int i=0; i<chArray.length; i++) {

            if ((chArray[i] != ' ' && chArray[i] != '\t')) {
                sb.append(chArray[i]);
            }
        }
        System.out.println("Final str="+sb);
    }
}
