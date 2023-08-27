/**
 * @author Eduard_Sardyka
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring.Solution().longestPalindrome("aaaa"));
        System.out.println(new LongestPalindromicSubstring.Solution().longestPalindrome("cdda"));
        System.out.println(new LongestPalindromicSubstring.Solution().longestPalindrome("babad"));
    }

    static class Solution {
        /**
         * https://leetcode.com/problems/longest-palindromic-substring/
         * Given a string s, return the longest palindromic substring in s.
         * Example 1:
         * Input: s = "babad"
         * Output: "bab"
         * Explanation: "aba" is also a valid answer.
         * Example 2:
         * Input: s = "cbbd"
         * Output: "bb"
         * Constraints:
         * 1 <= s.length <= 1000
         * s consist of only digits and English letters.
         */
        public String longestPalindrome(String s) {
            int maxLength = 0;
            int beginIndex = 0;
            int lastIndex = 0;
            int length = s.length();
            int maxIndex = length - 1;
            for (int i = 1; i < length; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    // if substring like "bb", next step: "abba",...
                    int begin = i - 1;
                    int last = i;
                    while (begin >= 0 && last < length && s.charAt(begin) == s.charAt(last)) {
                        int currentLength = last - begin;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            beginIndex = begin;
                            lastIndex = last;
                        }
                        begin--;
                        last++;
                    }
                }
                if (i < maxIndex && s.charAt(i + 1) == s.charAt(i - 1)) {
                    // if substring like "bab" or "bbb", next step: "dbabd",...
                    int begin = i - 1;
                    int last = i + 1;
                    while (begin >= 0 && last < length && s.charAt(begin) == s.charAt(last)) {
                        int currentLength = last - begin;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            beginIndex = begin;
                            lastIndex = last;
                        }
                        begin--;
                        last++;
                    }
                }
            }
            return s.substring(beginIndex, lastIndex + 1);
        }
    }
}