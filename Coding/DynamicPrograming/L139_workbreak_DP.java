import java.util.HashSet;

public class L139_workbreak_DP {


    public static void main(String[] args){

        String str = "catsanddog";
        String[] dict = {"cats", "dog","sand","and", "cat"};

        HashSet<String> dictset = new HashSet<>();

        for(String s : dict){
            dictset.add(s);
        }

        boolean res;
        System.out.println(" ############# workBreak_Bfs_memoization ");
        res = workBreak_DP(str, dictset);
        System.out.println(" res= "+res);

    }

    private static boolean workBreak_DP(String str, HashSet<String> dictset) {

        boolean[] dp = new boolean[str.length()+1];
        dp[0] = true;
        for(int i=1; i<=str.length(); i++){
            for(int j=0; j<i; j++){
                System.out.println("i= "+i + " j= "+j + " sub str= "+ str.substring(j,i)+ "         dp[j] "+dp[j]);
                if(dp[j] && dictset.contains(str.substring(j,i))) {
                    System.out.println("        Matched breaking");
                    dp[i] = true;
                    break;
                }
            }
            System.out.println("----");
        }
        return dp[str.length()];
    }
}
