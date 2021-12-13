public class Permutation {
    public static void main (String[] args){
        String str="abc";

        permutation("", str);
    }


    static void permutation(String processed, String up /* unprocessed*/) {

        if( up.isEmpty()) {
            System.out.println(processed);
            return;
        }
        //https://youtu.be/gDGw0cvFXPQ?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=942
        //code is added as per the permutation treee.
        //takeout the first "a" char from "abc"
        char ch = up.charAt(0);
        for(int i=0; i<= processed.length(); i++) {
            // abc - firstpart is ""
            String firstpart = processed.substring(0,i);
            // abc - secondpart is "bc
            String secondpart = processed.substring(i, processed.length());
            //a is inserted
            permutation(firstpart+ch+secondpart, up.substring(1));
        }

    } //method


    static int permutationCount(String processed, String up /* unprocessed*/) {

        if( up.isEmpty()) {
            System.out.println(processed);
            return 1;
        }
        //https://youtu.be/gDGw0cvFXPQ?list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&t=942
        //code is added as per the permutation treee.
        //takeout the first "a" char from "abc"
        char ch = up.charAt(0);
        int count = 0;
        for(int i=0; i<= processed.length(); i++) {
            // abc - firstpart is ""
            String firstpart = processed.substring(0,i);
            // abc - secondpart is "bc
            String secondpart = processed.substring(i, processed.length());
            //a is inserted
            count = count + permutationCount(firstpart+ch+secondpart, up.substring(1));
        }
        return count;

    } //method
}
