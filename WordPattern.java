import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern.Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new WordPattern.Solution().wordPattern("abba", "dog cat cat fish"));
    }

    static class Solution {
        /*
        Given a pattern and a string s, find if s follows the same pattern.
        Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
        Specifically:
            Each letter in pattern maps to exactly one unique word in s.
            Each unique word in s maps to exactly one letter in pattern.
            No two letters map to the same word, and no two words map to the same letter.
         */
        public boolean wordPattern(String pattern, String s) {
            String[] pt = pattern.split("");
            String[] st = s.split(" ");
            if(pt.length != st.length) {
                return false;
            }
            Map<String, List<Integer>> m1 = new HashMap<>();
            Map<String, List<Integer>> m2 = new HashMap<>();
            fillMap(pt, m1);
            fillMap(st, m2);
            for(int i = 0; i < pt.length; i++) {
                List<Integer> p1 = m1.get(pt[i]);
                List<Integer> p2 = m2.get(st[i]);
                if(!p1.equals(p2)) {
                    return false;
                }
            }
            return true;
        }

        private void fillMap(String[] ar, Map<String, List<Integer>> m) {
            for(int i = 0; i < ar.length; i++) {
                String str = ar[i];
                List<Integer> lt = m.get(str);
                if(lt == null) {
                    lt = new ArrayList<>();
                }
                lt.add(i);
                m.put(str, lt);
            }
        }
    }
}
