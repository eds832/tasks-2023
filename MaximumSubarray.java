public class MaximumSubarray {
    static class Solution {
        /**
         * Given an integer array nums, find the
         * subarray with the largest sum, and return its sum.
         * Example 1:
         * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
         * Output: 6
         * Constraints:
         * 1 <= nums.length <= 10^5
         * -10^4 <= nums[i] <= 10^4
         */
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int currentSum = 0;
            for (int i : nums) {
                currentSum += i;
                if (max < currentSum) {
                    max = currentSum;
                }
                if (currentSum < 0) {
                    // we found out that current i gives us a bad currentSum, so we clean it
                    currentSum = 0;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSubarray.Solution().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }
}