public class BinarySearch {

    public static void main(String[] args){

        int[] num = {1,2,3,4,5,6,7,8};

        binarySearch(num,0,7,5);
    }

    public static int binarySearch(int[] a, int low, int high, int key) {
        while(low <= high) {
            int mid = (low + high) / 2;
            System.out.println("low = " + low + " high= " + high + " mid= " + mid);
            System.out.println("  vals: low = " + a[low] + " high= " + a[high] + " mid= " + a[mid]);

            if (a[mid] == key) {
                System.out.println("key found");
                return key;
            }

            if (key < a[mid]) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return -1;

    } //method
}
