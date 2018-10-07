package javaconcept;

import java.util.BitSet;
import java.util.Scanner;

public class BitSetEx {

    enum OP {
        AND, OR, FLIP, SET
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        BitSet[] b = new BitSet[2];
        //BitSet b2 = new BitSet(n);
        b[0] = new BitSet(n);
        b[1] = new BitSet(n);


        for (int i = 0; i < m; i++) {
            String op = in.next();
            int s1 = Integer.parseInt(in.next());
            int s2 = Integer.parseInt(in.next());

            if (op.equals("AND")) {
                b[s1 - 1].and(b[s2 - 1]);
                System.out.println(b[s1 - 1].cardinality() + " " + b[s2 - 1].cardinality());
            } else if (op.equals("OR")) {
                b[s1 - 1].or(b[s2 - 1]);
                System.out.println(b[0].cardinality() + " " + b[1].cardinality());
            } else if (op.equals("SET")) {
                b[s1 - 1].set(s2-1);
                System.out.println(b[0].cardinality() + " " + b[1].cardinality());
            } else if (op.equals("FLIP")) {
                b[s1 - 1].flip(s2-1);
                System.out.println(b[0].cardinality() + " " + b[1].cardinality());
            } else if (op.equals("XOR")) {
                b[s1 - 1].xor(b[s2-1]);
                System.out.println(b[0].cardinality() + " " + b[1].cardinality());
            }
        }
    }
}
