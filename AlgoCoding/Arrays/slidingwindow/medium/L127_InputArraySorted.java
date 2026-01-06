package medium;

public class L127_InputArraySorted {
    public static void main(String[] args) {

        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] res = twoSum(numbers, target);
        System.out.println("Result: " + res[0] + ", " + res[1]);

    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {numbers[left], numbers[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
}
