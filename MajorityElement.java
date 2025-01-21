import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(new MajorityElement.Solution().majorityElement(nums));
    }

    /*
    Given an array nums of size n, return the majority element.
     */
    static class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.merge(num, 1, Integer::sum);
            }
            AtomicReference<Integer> majority = new AtomicReference<>(nums[0]);
            map.forEach((k,v) -> {
                if(v > map.get(majority.get())) {
                    majority.set(k);
                }
            });
            return majority.get();
        }
    }
}
