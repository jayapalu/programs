import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Generateparanthesis22 {

    public static void main(String[] args) {
        List<String> res = new ArrayList<String>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n= 3;
        generate(n,n,"",res);
        //return res;
        Random rand = new Random();




    }

    public static void generate(int open, int close, String str, List<String> res){

        if( open == 0 && close == 0) {
            res.add(str);
            return ;
        }

        if(open > 0) {
            generate(open-1, close,str+"(", res);
        }

        if(open < close){
            generate(open, close-1,str+")", res);
        }
    }
}
