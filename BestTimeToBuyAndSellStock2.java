public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock2.Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    /*
    You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
    On each day, you may decide to buy and/or sell the stock.
    You can only hold at most one share of the stock at any time.
    However, you can buy it then immediately sell it on the same day.
    Find and return the maximum profit you can achieve.
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int subProfit = prices[i] - min;
                if (subProfit > 0) {
                    profit += subProfit;
                    min = prices[i];
                } else {
                    min = Math.min(min, prices[i]);
                }
            }
            return profit;
        }
    }
}
