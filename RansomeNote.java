import java.util.HashMap;
import java.util.Map;

public class RansomeNote {

    public static void main(String[] args) {
        System.out.println(
                new RansomeNote.Solution().canConstruct("aa", "aab"));
    }

    static class Solution {
        /*
        Given two strings ransomNote and magazine,
        return true if ransomNote can be constructed by using the letters
        from magazine and false otherwise.
        Each letter in magazine can only be used once in ransomNote.
         */
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < magazine.length(); i++) {
                map.merge(magazine.charAt(i), 1, Integer::sum);
            }
            for(int i = 0; i < ransomNote.length(); i++) {
                char cr = ransomNote.charAt(i);
                Integer amount = map.get(cr);
                if(amount == null || amount == 0) {
                    return false;
                } else {
                    map.put(cr, amount - 1);
                }
            }
            return true;
        }
    }
}
