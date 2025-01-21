import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(new SingleNumber.Solution().singleNumber(new int[]{2, 2, 1}));
    }

    static class Solution {
        /*
        Given a non-empty array of integers nums,
        every element appears twice except for one.
        Find that single one.
         */
        public int singleNumber(int[] nums) {
            Map<Integer, Integer> m = new HashMap<>();
            for (int num : nums) {
                m.merge(num, 1, Integer::sum);
            }
            for (Integer key : m.keySet()) {
                if (m.get(key) == 1) {
                    return key;
                }
            }
            return 0;
        }
    }
}
