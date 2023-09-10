import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Eduard_Sardyka
 */
public class MaximumSlidingWindow {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            new MaximumSlidingWindow.Solution().maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        System.out.println(Arrays.toString(
            new MaximumSlidingWindow.Solution().maxSlidingWindow(new int[] { 9, 10, 9, -7, -4, -8, 2, -6 }, 5)));
    }

    static class Solution {
        /**
         * https://leetcode.com/problems/sliding-window-maximum
         * You are given an array of integers nums, there is a
         * sliding window of size k which is moving from the
         * very left of the array to the very right.
         * You can only see the k numbers in the window.
         * Each time the sliding window moves right by one position.
         * Return the max sliding window.
         * Example 1:
         * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
         * Output: [3,3,5,5,6,7]
         * Explanation:
         * Window position                Max
         * ---------------               -----
         * [1  3  -1] -3  5  3  6  7       3
         *  1 [3  -1  -3] 5  3  6  7       3
         *  1  3 [-1  -3  5] 3  6  7       5
         *  1  3  -1 [-3  5  3] 6  7       5
         *  1  3  -1  -3 [5  3  6] 7       6
         *  1  3  -1  -3  5 [3  6  7]      7
         *
         * Example 2:
         * Input: nums = [1], k = 1
         * Output: [1]
         * Constraints:
         * 1 <= nums.length <= 10^5
         * -10^4 <= nums[i] <= 10^4
         * 1 <= k <= nums.length
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] result = new int[nums.length - k + 1];
            int max = nums[0];
            int maxInd = 0;
            int loops = nums.length;
            for (int i = 0; i < loops; i++) {
                int ind = i - k + 1;
                if (maxInd < ind) {
                    max = nums[ind];
                    for (int j = ind + 1; j <= i; j++) {
                        int num = nums[j];
                        if (num >= max) {
                            max = num;
                            maxInd = j;
                        }
                    }
                } else if (nums[i] >= max) {
                    max = nums[i];
                    maxInd = i;
                }
                if (ind > -1) {
                    result[ind] = max;
                }
            }
            return result;
        }
    }
}