package javaconcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class subStrCompare {


    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        int len = s.length();
        int sublen = s.length() -k+1;
        String [] sub=new String[s.length()-k+1];
        int m=0;
        for(int i=0; i<=len-k; i++){
            sub[m++]=s.substring(i,i+k);
            System.out.println("sub:"+sub[m-1]);

        }

        for (int i=0; i<sublen-1; i++) {
            for (int j=i+1;j<sublen; j++){
                if(sub[i].compareTo(sub[j]) > 0){
                    String temp = sub[j];
                    sub[j]=sub[i];
                    sub[i]=temp;
                }
            }
        }
        //Arrays.sort(sub);
        smallest=sub[0];
        largest=sub[m-1];
        System.out.println(Arrays.toString(sub));
        s.toLowerCase();

        String s1="He is a very very good boy, isn't he?\n";
        String[] s2=s.split("\\s+|,|\\.|_|!|@|'|\\?",0);

        String reg="^(([01]?\\d\\d?|2[0-4]\\d?)|25[0-5]\\.){3}([01]?\\d\\d?|2[0-4]\\d?|25[0-5])$";



        List<String> result = new ArrayList<String>(s2.length);
        try {
            Pattern p = Pattern.compile("\\W");
        }catch (PatternSyntaxException e) {

        }




        // for (int i=0;i<j; i++){
         //   System.out.println(sub[i]);
        //}

        //sort substring
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}

