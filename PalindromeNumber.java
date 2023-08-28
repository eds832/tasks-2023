public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * https://leetcode.com/problems/palindrome-number/
     * Given an integer x, return true if x is a
     * palindrome, and false otherwise.
     * Example 1:
     * Input: x = 121
     * Output: true
     * Constraints:
     * -2^31 <= x <= 2^31 - 1
     */
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        return reverse(x) == x;
    }

    private static long reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10;
            result = result + x % 10;
            x = x / 10;
        }
        return result;
    }
}