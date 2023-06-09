import java.util.Arrays;

/**
 * @author Eduard_Sardyka
 * @since
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] {7,1,5,3,6,4}));
    }

    static class Solution {
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int result = 0;
            for (int i = 1; i < prices.length; i++) {
                if(prices[i] < min) {
                    min = prices[i];
                }
                int profit = prices[i] - min;
                if(profit > result) {
                    result = profit;
                }
            }
            return result;
        }
    }
}