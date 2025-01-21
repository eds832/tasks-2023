import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate2.Solution().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
        System.out.println(new ContainsDuplicate2.Solution().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
    }

    static class Solution {
        /*
        Given an integer array nums and an integer k,
        return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k == 0 || nums.length == 1) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            set.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (!set.add(nums[i])) {
                    return true;
                }
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;
        }
    }
}
