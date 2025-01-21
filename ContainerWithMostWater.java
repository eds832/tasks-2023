public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater.Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    static class Solution {
        /*
        You are given an integer array height of length n.
        There are n vertical lines drawn such that the two endpoints
        of the ith line are (i, 0) and (i, height[i]).
        Find two lines that together with the x-axis form a container,
        such that the container contains the most water.
        Return the maximum amount of water a container can store.
         */
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0, j = height.length - 1; i < j; ) {
                int h1 = height[i];
                int h2 = height[j];
                int h = Math.min(h1, h2);
                int w = j - i;
                max = Math.max(max, w * h);
                if (h1 < h2) {
                    i++;
                } else {
                    j--;
                }
            }
            return max;
        }
    }
}
