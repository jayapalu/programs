import java.util.Arrays;

public class L881_Boat_save_people {

    //Greedy two pointer
    public static void main(String[] args) {
        int[] people = new int[] {3,2,2,1};
        int limit = 3;

        int ans = numRescueBoats(people, limit);
        System.out.println(" ans = "+ans);

    }

    public static int numRescueBoats(int[] people, int limit) {

        int ans = 0;
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        while(start <= end) {
            System.out.println(" start = "+ start + " end= "+ end + " start val "+ people[start] + " end val "+ people[end]);
            ans++;
            if(people[start] + people[end] <= limit) {
                start++;
            }
            end--;
        }

        return ans;

    }
}
