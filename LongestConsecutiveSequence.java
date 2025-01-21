import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence.Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    static class Solution {
        /*
        Given an unsorted array of integers nums,
        return the length of the longest consecutive elements sequence.
         */
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return 1;
            }
            Arrays.sort(nums);
            Set<Integer> set = new HashSet<>();
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                int diff = nums[i] - nums[i - 1];
                if (diff == 1) {
                    len++;
                } else if (diff != 0) {
                    set.add(len);
                    len = 1;
                }
            }
            set.add(len);
            return set.stream().max(Integer::compare).get();
        }
    }
}
