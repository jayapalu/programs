public class L11_rainwater {

    public static void main(String[] args) {

        int[] a = {2,3,4,5,18,17,6};
                //{1,8,6,2,5,4,8,3,7};

        int res = maxRainWater(a);
        System.out.println("max area " + res);

    }

    static int maxRainWater(int[] a) {

        int maxArea = 0;
        int start = 0;
        int end = a.length - 1;


        while(start < end) {
            int m = a[start] > a[end] ? a[end] : a[start];

            int area = (end - start ) * m;
            System.out.println(" area ="+area + " m = "+m+ " start = "+start +" end= "+end +" "+ a[start] +"#"+a[end]);

            if(area > maxArea) {
                System.out.println("max area is updated");
                maxArea = area;
            }

            if(a[start] > a[end]) {
                end--;
            }else {
                start++;
            }
        }

        return maxArea;

    }
}
