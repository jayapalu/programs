package javaconcept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
//import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTagsContent {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Scanner in = new Scanner(System.in);
        new BufferedReader(new InputStreamReader(System.in));
       // String line = in.nextLine();
        //String line="<h1>Nayeem loves counseling</h1>";
        String line="<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";

        String reg = "<(.+)>([^<]+)</\\1>";

        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(line);
        boolean tagStrfound=false;

        while(m.find()){
            //System.out.println(m. group());
            System.out.println(m.group(2));
            tagStrfound = true;

        }

        if(!tagStrfound){
            System.out.println("None");
        }


        String str="HelloWorld";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        final byte[] rawdigest = md.digest(str.getBytes(Charset.defaultCharset()));


        StringBuffer sb = new StringBuffer();
        for (int i=0; i< rawdigest.length; i++){
            String hex = Integer.toHexString(0xff & rawdigest[i]);

            if (hex.length() == 1){
                sb.append('0');
            }
            sb.append(hex);
        }
        System.out.println(sb);



        MessageDigest md5=null;
        String str2=null;
        try{
            md5=MessageDigest.getInstance("MD5");
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        if (md5 != null) {
            str2 = toHexString(md5.digest(str.getBytes(Charset.defaultCharset())));
        }
        System.out.println(str2);

        List<Integer> list = new ArrayList<>();
        list.add(5, 23);
        list.remove(5);



    }

    private static String toHexString(byte[] b) {
        char[] hexChars={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c','d', 'e', 'f'};
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChars[(b[i] >> 4) & 0x0f]);
            sb.append(hexChars[(b[i]) & 0x0f]);
        }
        return sb.toString();
    }



        /*
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        Arrays.sort(s, Collections.reverseOrder(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1 == null || s2 == null){
                    return 0;
                }
                BigDecimal b1 = new BigDecimal(s1);
                BigDecimal b2 = new BigDecimal(s2);
                return b1.compareTo(b2);
            }
        }));


        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
        */
    }//

