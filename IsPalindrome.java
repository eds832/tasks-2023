/**
 * @author Eduard_Sardyka
 */
public class IsPalindrome {
    static class Solution {
        /**
         * Check if a given not null string is a palindrome (the text equals reverted one)
         */
        public boolean isPalindrome(String text) {
            int maxElemIndex = text.length() - 1;
            int halfLength = text.length() / 2;
            for (int right = 0; right < halfLength; right++) {
                int left = maxElemIndex - right;
                if (text.charAt(right) != text.charAt(left)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsPalindrome.Solution().isPalindrome("abcba"));
        System.out.println(new IsPalindrome.Solution().isPalindrome("abcddcba"));
        System.out.println(new IsPalindrome.Solution().isPalindrome("aba"));
        System.out.println(new IsPalindrome.Solution().isPalindrome("a"));
        System.out.println(new IsPalindrome.Solution().isPalindrome(""));
        System.out.println(new IsPalindrome.Solution().isPalindrome("abcbaa"));
        System.out.println(new IsPalindrome.Solution().isPalindrome("abcddcbas"));
        System.out.println(new IsPalindrome.Solution().isPalindrome("abab"));
        System.out.println(new IsPalindrome.Solution().isPalindrome("ab"));
    }
}