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

        Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        in.close();

        if (n<-100 || n>100){
            System.out.println("invalid range");
        }

        boolean flag=false;
        String s="";
        if (n==0){
            s="0";
        }
        if (n<0){
            n=n*-1;
            flag=true;
        }
        int rem=0;
        int num=n;
        while(num !=0){
            rem=num%10;
            char ch1=(char)(rem+'0');
            //System.out.println("char "+ch1);
            //System.out.println("Char to str "+ Character.toString(ch1));
            s=s.concat(Character.toString(ch1));
            //System.out.println("concat "+s);
            num=num/10;
        }
        System.out.println("reverse s="+s);
        s=new StringBuffer(s).reverse().toString();

        s=new StringBuffer("-").append(s).toString();
        System.out.println("s="+Integer.parseInt(s));
        if(flag)
            n=n*-1;

        if (n==Integer.parseInt(s)) {
            System.out.println("Good job");
        }




    }
}
