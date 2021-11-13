//43. Multiply Strings
/*

 */

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings {


    public static void main(String[] args) {
        String str1 = "2";
        String str2 = "3";

        // -ve numbers case
        if ((str1.charAt(0) == '-' || str2.charAt(0) == '-') &&
                (str1.charAt(0) != '-' || str2.charAt(0) != '-'))
            System.out.print("-");

        //-ve number then start from index 1
        if (str1.charAt(0) == '-')
            str1 = str1.substring(1);

        if (str2.charAt(0) == '-')
            str2 = str2.substring(1);

        multiply(str1, str2);
    }

    public static String multiply(String str1, String str2) {

        int l1 = str1.length();
        int l2 = str2.length();
        int[] result = new int [l1+l2];

        int i_n1 = 0;
        int i_n2 = 0;

        int n1 = 0;
        int n2 = 0;
        int sum = 0;
        int carry = 0;

        for( int i = l1 -1 ; i>=0; i--) {

            n1 = str1.charAt(i) - '0';
            i_n2 = 0;
            carry = 0;
            System.out.println("n1 = "+n1);
            System.out.println("    "+Arrays.toString(result));
            for(int j=l2-1; j >= 0; j--){

                n2 = str2.charAt(j)-'0';
                System.out.println("    n2 = "+n2);
                //adding the current multiplication with the previous poistion values
                sum = n1 * n2 + result [ i_n1 + i_n2] + carry;
                System.out.println("    sum = "+sum);
                carry = sum / 10;
                System.out.println("    carry = "+ carry);

                result[i_n1 + i_n2] = sum % 10;
                i_n2++;
                System.out.println("    "+Arrays.toString(result));
                System.out.println("    ");
            }
            if(carry > 0)
                System.out.println("        last carry = "+ carry);
                result[i_n1 + i_n2 ] += carry;
            i_n1++;
        }

        //if(carry > 0) {
           // System.out.println("        last carry = "+ carry);
            //result[i_n1 + i_n2 - 1] = carry;
       // }

        int k = result.length - 1;

        System.out.println(Arrays.toString(result));
        //if all zeros in result  ex: 123 * 0 - this can also be handled initially by checking 0
        System.out.println("k="+k +"char at "+ result[k]);
        while(k >= 0 && result[k] == 0){
            k--;
        }

        if(k == -1)
            return "0";

        String s="";
        while(k >=0 ) {
            s += result[k--];
        }

        System.out.println(s);
        return s;
    }
}