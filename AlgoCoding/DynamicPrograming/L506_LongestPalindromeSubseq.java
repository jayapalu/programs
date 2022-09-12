public class L506_LongestPalindromeSubseq {

    //https://emre.me/coding-patterns/palindromes/
    public static void main(String[] args) {

        String s = "aabkbaad";

        int res = 0;
        res = palindrome_subseq(s);
        System.out.println(" length of palindrome subseq="+ res);
        res = palindrome_subseq_memoization(s);
        System.out.println(" palindrome_subseq_memoization length of palindrome subseq= "+ res);
    }

    static int palindrome_subseq(String s) {

        return palindrome_subseq(s, 0, s.length()-1);

    }

    private static int palindrome_subseq(String s, int start, int end) {

        System.out.println("Start="+start + " end= "+end);
        if(start > end){
            return 0;
        }

        // single char
        if(start == end){
            System.out.println("Start=== end");
            return 1;
        }

        //when the first and last char are equal then add count 2
        if(s.charAt(start) == s.charAt(end)) {
            return  2 + palindrome_subseq(s, start+1, end -1 );
        }

        //skip the first char and try
        int seq1 = palindrome_subseq(s, start+1, end );
        //skip the last char and try
        int seq2 = palindrome_subseq(s, start, end-1 );

        System.out.println("   >>>Start="+start + " end= "+end);
        return Math.max(seq1, seq2);
    }

    private static int palindrome_subseq_memoization(String s) {
        int[][] mem = new int[s.length()][s.length()];
        return palindrome_subseq_memoization(s, 0, s.length()-1, mem);
    }

    private static int palindrome_subseq_memoization(String s, int start, int end, int[][] mem) {

       // System.out.println("Start="+start + " end= "+end);
        if(start > end){
            return 0;
        }

        // single char
        if(start == end){
            //System.out.println("Start=== end");
            mem[start][end] = 1;
            return 1;
        }

        if (mem[start][end] != 0 ) {
            return mem[start][end] ;
        }

        //when the first and last char are equal then add count 2
        if(s.charAt(start) == s.charAt(end)) {
            mem[start][end] =  2 + palindrome_subseq_memoization(s, start+1, end -1, mem);
        } else {

            //skip the first char and try
            int seq1 = 0;
            int seq2 = 0;
            seq1 = palindrome_subseq_memoization(s, start + 1, end, mem);
            //skip the last char and try
            seq2 = palindrome_subseq_memoization(s, start, end - 1, mem);

            mem[start][end] = Math.max(seq1, seq2);
           // System.out.println("   >>>Start=" + start + " end= " + end + "mem = " + mem[start][end]);
        }
        return mem[start][end];
    }


}
