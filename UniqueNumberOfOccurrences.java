import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * @author Eduard_Sardyka
 */
class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
    }

    static class Solution {
        /**
         * Given an array of integers arr, return true if the number
         * of occurrences of each value in the array is unique or false otherwise.
         * Example 1:
         * Input: arr = [1,2,2,1,1,3]
         * Output: true
         * Constraints:
         * 1 <= arr.length <= 1000
         * -1000 <= arr[i] <= 1000
         */
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>(arr.length);
            ArrayList<Integer> list = new ArrayList<>(arr.length);
            for (int i : arr) {
                map.merge(i, 1, (oldValue, newValue) -> oldValue + newValue);
            }
            for (Integer i : map.keySet()) {
                if (!list.contains(map.get(i))) {
                    list.add(map.get(i));
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}