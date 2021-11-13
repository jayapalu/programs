import java.util.Arrays;
public class Twonums1 {
    public static void main(String[] args) {

        int[] num = new int[] {1,2,3,4,5};
        twonums(num, 7);
    }

    public static void twonums(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0; i < nums.length; i++){
            int diff = target - nums[i];
            int ele = findEle(nums, 0,  nums.length -1, diff);
            System.out.println("Ele = "+ ele);
        }
    }

    public static int findEle(int[] nums, int low, int high, int ele) {

        int mid = (low + high) / 2;
        System.out.println(" === low=" + low + " high= " + high + " mid=" + mid + "nums[mid] " + nums[mid] + "ele ="+ele);
        while (low < high) {
            if (nums[mid] == ele) {
                return mid;
            } else if (ele < nums[mid]) {
                //System.out.println("less mid=" + mid + " nums[mid] " + nums[mid]);
                return findEle(nums, low, (mid - 1), ele);
            } else {
                //System.out.println(" high mid=" + mid + " nums[mid] " + nums[mid]);
                return findEle(nums, (mid + 1), high, ele);
            }

        }
        return mid;
    }
}

