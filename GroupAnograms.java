import java.util.*;

public class GroupAnograms {

    public static void main(String[] args) {
        System.out.println(new GroupAnograms.Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class Solution {
        /*
        Given an array of strings strs, group the anagrams together.
        You can return the answer in any order.
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String st : strs) {
                char[] ar = st.toCharArray();
                Arrays.sort(ar);
                String st2 = new String(ar);
                List<String> lt = map.computeIfAbsent(st2, key -> new ArrayList<>());
                lt.add(st);
            }
            return new ArrayList<>(map.values());
        }

    }

}
