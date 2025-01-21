public class IsSubSequence {

    public static void main(String[] args) {
        System.out.println(new IsSubSequence.Solution().isSubsequence("abc", "ahbgdc"));
        System.out.println(new IsSubSequence.Solution().isSubsequence("axc", "ahbgdc"));
    }

    static class Solution {
        /*
        A subsequence of a string is a new string that is formed from the original string by deleting some
        (can be none) of the characters without disturbing the relative positions of the remaining characters.
        (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
         */
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) return true;
            int pointer = 0;
            char c = s.charAt(0);
            for (int i = 0; i < t.length(); i++) {
                if (c == t.charAt(i)) {
                    if (pointer == s.length() - 1) return true;
                    pointer++;
                    c = s.charAt(pointer);
                }
            }
            return false;
        }
    }
}
