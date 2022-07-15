import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class L139_WorkdBreak_BFS {

    public static void main(String[] args){

        String str = "catsandog";
        str.split("\\s+");

        String[] dict = {"cats","dog","sand","and","cat"};

        HashSet<String> dictset = new HashSet<>();

        for(String s : dict){
            dictset.add(s);
        }

        boolean res;
        res = workBreak_Bfs(str, dictset);
        System.out.println(" res= "+res);

        System.out.println(" ############# workBreak_Bfs_memoization ");
        res = workBreak_Bfs_memoization(str, dictset);

        System.out.println("  workBreak_dfs_memoization res= "+res);

    }
    //BFS but no recursion
    static boolean workBreak_Bfs(String str, HashSet<String> dictSet) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while(!queue.isEmpty()){
            int start = queue.poll();
            System.out.println("start = "+start);

            //substring method excludes end so end = start + 1
            for(int end = start + 1; end <= str.length() ; end++) {

                System.out.println("        end = " + end);
                if (dictSet.contains(str.substring(start, end))){
                    System.out.println("String matched = " + str.substring(start, end));
                    queue.add(end);

                    // last word in the string is matched that means all the words are matched.
                    if(end == str.length()){
                        return true;
                    }
                }
            } //for
        } //while

        return false;
    }



    static boolean workBreak_Bfs_memoization(String str, HashSet<String> dictSet) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[str.length()+1];
        queue.add(0);

        while(!queue.isEmpty()){
            int start = queue.poll();
            //System.out.println("start = "+start);

            if(visited[start]){
                //System.out.println("    already visited ..continueing start ="+start);
                continue;
            }

            //substring method excludes end so end = start + 1
            for(int end = start + 1; end <= str.length() ; end++) {

                //System.out.println("        end = " + end);
                if (dictSet.contains(str.substring(start, end))){
                   // System.out.println("String matched = " + str.substring(start, end));
                    queue.add(end);

                    // last word in the string is matched that means all the words are matched.
                    if(end == str.length()){
                        return true;
                    }
                }
            } //for
            visited[start] = true;
        } //while

        return false;
    }
}
