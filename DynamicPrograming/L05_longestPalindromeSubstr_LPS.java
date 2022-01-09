public class L05_longestPalindromeSubstr_LPS {

    public static void main(String[] args) {

        String s = "ccc";
        String res;
        res = longestPalindrome_bruteForce(s);
        System.out.println("longestPalindrome_bruteForce palindrome substr = "+res);

        //res = LPS(s);
        //System.out.println("LPS palindrome substr = "+res);

       res = LPS_optimized(s);
        System.out.println("LPS_optimized  substr = "+res);
    }

    //https://www.youtube.com/watch?v=UflHuQj6MVA
    static String  LPS_optimized(String s) {

        int palindrome_maxtrix[][] = new int[s.length()][s.length()];
        int maxlength = 0;
        int startIndex = 1;

        for(int i=0; i< s.length(); i++){
            //lenth 1
            palindrome_maxtrix[i][i] = 1;
            maxlength = 1;
            startIndex = i;
        }

        for(int i=0; i< s.length()-1; i++) {
            //lenth 2
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome_maxtrix[i][i + 1] = 1;
                startIndex = i;
                maxlength = 2;
            }
        }

        // for substrings length from 3 to length - 1;
        //  k < s.length() then full string, k<s.length-1 then only substrings
        // Here k is length so condition is k<=s.length()
        for(int k=3; k<=s.length(); k++){

            // 0th char to all the lengths
            for(int i=0; i<= s.length()-k ; i++){
                //j condition
                int j = i + k  - 1;
                System.out.println( "k= "+k +" i="+i + " j= "+j + " maxtrix= "+ palindrome_maxtrix[i+1][j-1]);
                //for abba   s[i] = a and s[length] = a and checking wether bb is palindrome or not
                if(s.charAt(i) == s.charAt(j) && palindrome_maxtrix[i+1][j-1] == 1){
                    System.out.println("Maxlength = "+ maxlength + " startIndex= "+i);
                    palindrome_maxtrix[i][j] = 1;

                    if(k > maxlength){
                        System.out.println("Maxlength = "+ maxlength + " startIndex= "+i);
                        maxlength = k;
                        startIndex = i;
                    }
                }

            } //for
        }//for

        return s.substring(startIndex, startIndex+maxlength);
    }

    public static String  LPS(String s) {

        String res = "";
        res = palindromestr(s, 0, s.length()-1, res);
        //System.out.println("LSP is = "+ res);
        return  res;
    }

    public static String palindromestr(String s, int start, int end, String res) {

        System.out.println("start = " + start + " end = " + end);
        if (start == end) {
            if((end-start) > res.length()-1 ) {
                res = s.substring(start, end+1);
            }
            return res;
        }
        if (isPalindrome(s, start, end)) {
            System.out.println("Palindrome #### start " + start + " end= " + end);
            System.out.println(s.substring(start, end+1));
            if((end-start) > res.length()-1) {
                res = s.substring(start, end+1);
                System.out.println("str is = "+ res);
            }
        }

        res = palindromestr(s, start, end - 1, res);
        System.out.println(">>>>>");
        res = palindromestr(s, start + 1, end, res);

        return res;
    }


    static public String longestPalindrome_bruteForce(String s) {

        int start = 0;
        int end = s.length() - 1;
        int len = s.length();

        if (len == 1) {
            return s;
        }

        int sIndex = 0;
        int eIndex = 0;

        int max = 0;

        for (start = 0; start < len; start++) {

            for (end = start + 1; end < len; end++) {

                // System.out.println("start"+start + " end= "+end);

                if (isPalindrome(s, start, end)) {
                    if (end - start + 1 > max) {
                        max = end - start + 1;
                        sIndex = start;
                        eIndex = end;
                    }
                }

            }
        }

        return s.substring(sIndex, eIndex + 1);
    }

    static boolean isPalindrome(String s, int start, int end) {

        //System.out.println("isPalindrome start"+start + " end= "+end);
        while (start < end) {

            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        //System.out.println("Panlindrome###");
        return true;
    }




}
