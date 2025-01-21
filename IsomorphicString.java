import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsomorphicString {

    public static void main(String[] args) {
        System.out.println(new IsomorphicString.Solution().isIsomorphic(
                "aaaaabbbbbcccccdddddeeeee", "pppppqqqqqrrrrrsssssttttt"));
    }

    static class Solution {
        /*
        Given two strings s and t, determine if they are isomorphic.
        Two strings s and t are isomorphic if the characters in s can be replaced to get t.
        All occurrences of a character must be replaced with another character
        while preserving the order of characters. No two characters may map to the same character,
        but a character may map to itself.
         */
        public boolean isIsomorphic(String s, String t) {
            Map<Character, List<Integer>> map1 = new HashMap<>();
            Map<Character, List<Integer>> map2 = new HashMap<>();
            fillMap(s, map1);
            fillMap(t, map2);
            if (map1.size() != map2.size()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                List<Integer> p1 = map1.get(c1);
                char t1 = t.charAt(i);
                List<Integer> p2 = map2.get(t1);
                if (!p2.equals(p1)) {
                    return false;
                }
            }
            return true;
        }

        private void fillMap(String str, Map<Character, List<Integer>> map) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                List<Integer> lt = map.get(c);
                if (lt == null) {
                    lt = new ArrayList<>();
                }
                lt.add(i);
                map.put(c, lt);
            }
        }
    }
}
