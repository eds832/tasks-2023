/**
 * @author Eduard_Sardyka
 */
public class TrappingRainWater {
    static class Solution {
        /**
         * Given n non-negative integers representing an elevation map
         * where the width of each bar is 1,
         * compute how much water it can trap after raining.
         * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
         * Output: 6
         * Explanation: The above elevation map (black section) is
         * represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
         * In this case, 6 units of rain water (blue section) are being trapped.
         * Constraints:
         * n == height.length
         * 1 <= n <= 2 * 10^4
         * 0 <= height[i] <= 10^5
         */
        public int trap(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int leftMax = height[0];
            int rightMax = height[right];
            int vol = 0;
            while (left < right) {
                int heightLeft = height[left];
                if (heightLeft > leftMax) {
                    leftMax = heightLeft;
                }
                int heightRight = height[right];
                if (heightRight > rightMax) {
                    rightMax = heightRight;
                }
                if (leftMax < rightMax) {
                    // leftMax less than rightMax -> water keeps leftMax,
                    // so we can get it
                    int additionalWater = leftMax - heightLeft;
                    vol += additionalWater;
                    // we proceed with the left side
                    left++;
                } else {
                    // leftMax >= rightMax -> water keeps rightMax,
                    // so we can get it
                    int additionalWater = rightMax - heightRight;
                    vol += additionalWater;
                    // we proceed with the right side
                    right--;
                }
            }
            return vol;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater.Solution().trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }
}