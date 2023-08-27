/**
 * @author Eduard_Sardyka
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring.Solution().longestPalindrome("aaaaa"));
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
            int add = 0;
            // add - additional offset to speed up the search by skipping worse results
            byte[] chars = s.getBytes(); // chars[i] works 2 times faster than s.charAt(i)
            for (int i = 1; i < length - add; i++) {
                int start = i - add - 1;
                int end = i + add;
                if (chars[start] == chars[end]) {
                    // if substring like "bb", next step: "abba",...
                    int begin = i - 1;
                    int last = i;
                    while (begin >= 0 && last < length && chars[begin] == chars[last]) {
                        int currentLength = last - begin;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            beginIndex = begin;
                            lastIndex = last;
                            add = maxLength / 2;
                        }
                        begin--;
                        last++;
                    }
                }
            }
            for (int i = 1 + add; i < length - 1 - add; i++) {
                int start = i - add - 1;
                int end = i + add + 1;
                if (chars[end] == chars[start]) {
                    // if substring like "bab" or "bbb", next step: "kbabk",...
                    int begin = i - 1;
                    int last = i + 1;
                    while (begin >= 0 && last < length && chars[begin] == chars[last]) {
                        int currentLength = last - begin;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                            beginIndex = begin;
                            lastIndex = last;
                            add = maxLength / 2;
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