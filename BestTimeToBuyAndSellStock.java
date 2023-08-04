/**
 * @author Eduard_Sardyka
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to
     * buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Constraints:
     * 1 <= prices.length <= 10^5
     * 0 <= prices[i] <= 10^4
     */
    static class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int profit = 0;
            int length = prices.length;
            for (int i = 1; i < length; i++) {
                int price = prices[i];
                if (price < min) {
                    min = price;
                }
                int diff = price - min;
                if (diff > profit) {
                    profit = diff;
                }
            }
            return profit;
        }
    }
}