import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Eduard_Sardyka
 */
public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(new ThreeSum.Solution().threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }

    static class Solution {
        /**
         * https://leetcode.com/problems/3sum/
         * Given an integer array nums, return all the triplets
         * [nums[i], nums[j], nums[k]] such that i != j, i != k,
         * and j != k, and nums[i] + nums[j] + nums[k] == 0.
         * Notice that the solution set must not contain duplicate triplets.
         * Example 1:
         * Input: nums = [-1,0,1,2,-1,-4]
         * Output: [[-1,-1,2],[-1,0,1]]
         * Explanation:
         * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
         * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
         * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
         * The distinct triplets are [-1,0,1] and [-1,-1,2].
         * Notice that the order of the output and the order of the triplets does not matter.
         * Constraints:
         * 3 <= nums.length <= 3000
         * -10^5 <= nums[i] <= 10^5
         */
        public List<List<Integer>> threeSum(int[] nums) {
            // O(n * log n) + O(n^2) < O(n^3)
            Arrays.sort(nums); // O(n * log n)
            List<List<Integer>> result = new ArrayList<>();
            int maxIndex = nums.length - 1;
            int maxJIndex = maxIndex - 1;
            boolean isFirstRun = true;
            for (int i = 0; i < maxJIndex; i++) { // O(n^2)
                // skip same nums starting second run
                if (isFirstRun || nums[i] != nums[i - 1]) {
                    isFirstRun = false;
                    int j = i + 1;
                    int k = maxIndex;
                    int addition = 0 - nums[i];
                    while (j < k) {
                        if (nums[j] + nums[k] == addition) {
                            List<Integer> record = new ArrayList<>();
                            record.add(nums[i]);
                            record.add(nums[j]);
                            record.add(nums[k]);
                            result.add(record);
                            // skip same nums
                            while (j < maxJIndex && nums[j] == nums[j + 1]) {
                                j++;
                            }
                            while (k > 2 && nums[k] == nums[k - 1]) {
                                k--;
                            }
                            j++;
                            k--;
                        } else if (nums[j] + nums[k] < addition) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
            return result;
        }
    }
}