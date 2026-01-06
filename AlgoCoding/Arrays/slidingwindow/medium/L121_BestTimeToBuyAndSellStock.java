package slidingwindow.medium;

public class L121_BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        int maxProfit = maxProfit(prices);

        System.out.println("Max Profit = " + maxProfit);
    }


    public static int maxProfit(int[] prices) {
        int lowSofar = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < lowSofar) {
                lowSofar = prices[i];
            }else if(prices[i] - lowSofar > maxProfit) {
                maxProfit = prices[i] - lowSofar;
            }
        }
        return maxProfit;
    }


    public static int maxProfit2(int[] prices) {
        int lowSofar = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < lowSofar) {
                lowSofar = prices[i];
            }else if(prices[i] - lowSofar > maxProfit) {
                maxProfit = prices[i] - lowSofar;
            }
        }
        return maxProfit;
    }
}
