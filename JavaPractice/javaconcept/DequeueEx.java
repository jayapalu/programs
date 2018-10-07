package javaconcept;

import java.util.*;

public class DequeueEx {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int j = 0;
        int max = Integer.MIN_VALUE;
        int ele;
        Set<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();

            if (j < m) {
                deque.addLast(num);
                s.add(num);
                if (s.size() > max) {
                    max = s.size();
                }
                j++;
            } else {
                ele = (int) deque.removeFirst();
                deque.addLast(num);
                if (!deque.contains(ele)) {
                    s.remove(ele);
                }
                s.add(num);

                if (s.size() > max) {
                    max = s.size();
                }
            }

        }

        System.out.println(max);
    }
}
