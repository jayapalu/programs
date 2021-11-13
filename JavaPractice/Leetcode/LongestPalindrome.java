
public class LongestPalindrome {
    public static void main(String[] args){
        String str = "geeks";

        palinsubstrings(str);
    }

    public  static void palinsubstrings(String str){

        for(int i = 0; i< str.length(); i++){
            for(int j = i; j<str.length(); j++){
                int end = j;
                int start = i;
                System.out.println(i+"->"+j);
                for(int k = 0; k<(end-start+1)/2;  k++){
                    //System.out.print(str.charAt(k+i)+"-"+str.charAt(j-k) + " ");
                    System.out.print((k+i)+"-"+ (j-k) + " ");
                }
                System.out.println("  ");
            }

        }

    }

}
