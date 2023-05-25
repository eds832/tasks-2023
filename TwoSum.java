import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Arrays.stream(new Solution().twoSum(new int[] {2,7,11,15}, 9)).forEach(System.out::println);
    }

    static class Solution {
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