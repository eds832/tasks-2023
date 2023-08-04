public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
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
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.toString().equals(sb.reverse().toString());
    }
}