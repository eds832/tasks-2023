import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Eduard_Sardyka
 */
public class TwoSum {

    public static void main(String[] args) {
        Arrays.stream(new Solution().twoSum(new int[] {2,7,11,15}, 9)).forEach(System.out::println);
    }

    static class Solution {
        /**
         * Given an array of integers nums and an integer target,
         * return indices of the two numbers such that they add up to target.
         * You may assume that each input would have exactly one solution,
         * and you may not use the same element twice.
         * You can return the answer in any order.
         * Example 1:
         * Input: nums = [2,7,11,15], target = 9
         * Output: [0,1]
         * Constraints:
         * 2 <= nums.length <= 10^4
         * -10^9 <= nums[i] <= 10^9
         * -10^9 <= target <= 10^9
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[0], 0);
            for(int i = 1; i < nums.length; i++) {
                int diff = target - nums[i];
                if(map.containsKey(diff)) {
                    int [] arr = new int [2];
                    arr[0] = i;
                    arr[1] = map.get(diff);
                    return arr;
                } else {
                    map.put(nums[i], i);
                }
            }
            return null;
        }
    }
}