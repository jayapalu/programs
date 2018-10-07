package javaconcept;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayOfArrayList {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if (size <1 && size > 20000){
            return;
        }
        ArrayList al[] = new ArrayList[size];

        for (int i=0; i<size; i++) {
            int itemSize = scanner.nextInt();
            if(itemSize < 0 && itemSize > 50000) {
                return;
            }

            al[i] = new ArrayList();
            if (itemSize <= 0){
                continue;
            }
            for(int j=0;j<itemSize; j++){
                al[i].add(scanner.nextInt());
            }
        }

        int outputsize = scanner.nextInt();
        if(outputsize <1 && outputsize > 1000){
            return;
        }

        for(int i=0; i< outputsize;i++){
            int list = scanner.nextInt();
            if(list <1 && list > 50000){
                return;
            }

            int index = scanner.nextInt();

            if (list >0 && list <= size && al[list-1].size()>0 && index <= al[list-1].size()) {
                System.out.println(al[list-1].get(index-1));
            } else {
                System.out.println("ERROR!");
            }
        }
    }
}
