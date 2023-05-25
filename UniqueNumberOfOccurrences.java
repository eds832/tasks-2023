import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
    }

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>(arr.length);
            ArrayList<Integer> list = new ArrayList<>(arr.length);
            for (int i = 0; i < arr.length; i++) {
                map.merge(arr[i], 1, (o, n) -> o + n);
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