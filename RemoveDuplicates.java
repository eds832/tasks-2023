import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        System.out.println(new RemoveDuplicates.Solution().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Given an integer array nums sorted in non-decreasing order,
     * remove some duplicates in-place such that each unique element appears at most twice.
     * The relative order of the elements should be kept the same.
     *
     * Since it is impossible to change the length of the array in some languages,
     * you must instead have the result be placed in the first part of the array nums.
     * More formally, if there are k elements after removing the duplicates,
     * then the first k elements of nums should hold the final result.
     * It does not matter what you leave beyond the first k elements.
     *
     * Return k after placing the final result in the first k slots of nums.
     */
    static class Solution {
        public int removeDuplicates(int[] nums) {
            Map<Integer, Integer> map = new TreeMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            int j = 0;
            for(Integer key : map.keySet()) {
                int value = map.get(key);
                for(int k = 1; k <= value && k < 3; k++) {
                    nums[j] = key;
                    j++;
                }
            }
            return j;
        }
    }
}
