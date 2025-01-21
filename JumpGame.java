public class JumpGame {
    public static void main(String[] agrs) {
        System.out.println(new JumpGame.Solution().canJump(new int[] {2,3,1,1,4}));
        System.out.println(new JumpGame.Solution().canJump(new int[] {3,2,1,0,4}));
    }

    static class Solution {
        /*
        You are given an integer array nums.
        You are initially positioned at the array's first index,
        and each element in the array represents your maximum jump length at that position.
        Return true if you can reach the last index, or false otherwise.
         */
        public boolean canJump(int[] nums) {
            int maxAvailable = 0;
            int maxIndex = nums.length - 1;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0 && i <= maxAvailable) {
                    maxAvailable = Math.max(nums[i] + i, maxAvailable);
                }
                if(maxAvailable >= maxIndex) {
                    return true;
                }
            }
            return false;
        }
    }
}
