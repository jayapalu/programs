import java.util.*;

public class L752_OpenLock {

    public static void main(String[] args) {

        String target = "369";
        Queue<String> queue = new LinkedList<>();
        queue.add("000");
        //lock next combination for the next rotation.

        if (target.equals("000")){
            System.out.println("-1");
            return;
        }

       int rotationCount =  lock_BFS(queue, target);
        System.out.println("roationCount = "+ rotationCount);

    }

    public static int lock_BFS(Queue<String> queue, String target) {

        Set<String> visited = new HashSet<>();
        int rotationCount = 0;

        while (!queue.isEmpty()) {

            String item = queue.poll();
            visited.add(item);

            System.out.println(" current queue item "+ item);
            List<String> results = nextCombination(item, queue);
            System.out.println(results);

            for(String nextNum : results){

                rotationCount = rotationCount + 1;
                if (nextNum.equals(target)){
                    System.out.println("########target found ######");
                    return rotationCount;
                }

                if(visited.contains(nextNum)){
                    System.out.println(" Item already visited, so skipping " + nextNum);
                    continue;
                }
                queue.add(nextNum);
            }

        }
        return rotationCount;
    }

    static List<String> nextCombination(String input, Queue<String> queue) {

        System.out.println("Input = "+input);
        List<String> nextCombinations = new ArrayList<>();

        char[] num = input.toCharArray();

        for(int i = 0; i< num.length; i++){

            char currentChar = num[i];

            //forward rotate
            num[i] = currentChar == '9' ? '0' : (char) (currentChar + 1);
            nextCombinations.add(String.valueOf(num));
            System.out.println("forward  = "+ String.valueOf(num));

            //backward rotate
            num[i] = currentChar == '0' ? '9' : (char) (currentChar - 1);
            nextCombinations.add(String.valueOf(num));
            System.out.println("backward  = "+ String.valueOf(num));

            //reset the current char so that next combination will have the current char as is

            num[i] = currentChar;

        }

        return nextCombinations;
    }
}