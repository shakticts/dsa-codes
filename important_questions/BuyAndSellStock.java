package important_questions;

public class BuyAndSellStock {
    // Best time to buy and sell stock I
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, profit = 0;
        for (int p : prices) {
            if (p < min) min = p;
            else profit = Math.max(profit, p - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max profit: " + maxProfit(prices));
    }
}
