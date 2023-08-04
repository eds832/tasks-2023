/**
 * @author Eduard_Sardyka
 */
public class SearchInsertPostion {
/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 **/
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int i = 0;
            while(i < nums.length) {
                if(nums[i] < target) {
                    i++;
                } else {
                    break;
                }
            }
            return i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPostion.Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 5));
    }
}