import java.util.ArrayList;
import java.util.List;

public class L118_PascalTriangle {

    public  static void main(String[] args) {

        int numRows = 4;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);

        result.add(list);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);
            System.out.println(prevRow);
            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
                System.out.print(row);
            }
            row.add(1);


            result.add(row);
        }

      //  return result;
    }

}
