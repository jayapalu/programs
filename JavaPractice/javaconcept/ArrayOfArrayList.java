package javaconcept;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayOfArrayList {
    public static void main(String[] args) {

        /*
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        if (size < 1 && size > 20000) {
            return;
        }
        ArrayList al[] = new ArrayList[size];

        for (int i = 0; i < size; i++) {
            int itemSize = scanner.nextInt();
            if (itemSize < 0 && itemSize > 50000) {
                return;
            }

            al[i] = new ArrayList();
            if (itemSize <= 0) {
                continue;
            }
            for (int j = 0; j < itemSize; j++) {
                al[i].add(scanner.nextInt());
            }
        }

        int outputsize = scanner.nextInt();
        if (outputsize < 1 && outputsize > 1000) {
            return;
        }

        for (int i = 0; i < outputsize; i++) {
            int list = scanner.nextInt();
            if (list < 1 && list > 50000) {
                return;
            }

            int index = scanner.nextInt();

            if (list > 0 && list <= size && al[list - 1].size() > 0 && index <= al[list - 1].size()) {
                System.out.println(al[list - 1].get(index - 1));
            } else {
                System.out.println("ERROR!");
            }
        }

*/
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        for(int i=10; i<20; i=i+2){
            A.add(i);
        }

        for(int i=20; i<30; i=i+2){
            B.add(i);
        }

        order(A,B);
    }

    public static ArrayList<Integer> order(ArrayList<Integer> A, ArrayList<Integer> B) {

        int len1 = A.size();
        int len2 = B.size();

        int aindex = 0;
        int bindex = 0;

        ArrayList<Integer> C = new ArrayList<Integer>();
        while (aindex < len1 && bindex < len2) {
            if (A.get(aindex) < B.get(bindex)) {
                C.add(A.get(aindex));
                aindex++;
            } else {
                C.add(B.get(bindex));
                bindex++;
            }
        }

        while (aindex < len1) {
            C.add(A.get(aindex++));
        }
        while (bindex < len2) {
            C.add(A.get(bindex++));
        }

        for(int i=0; i<C.size(); i++){
            System.out.println(C.get(i));
        }
        return C;
    }
}


