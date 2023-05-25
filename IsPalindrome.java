
public class IsPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("abcddcba"));
        System.out.println(isPalindrome("aba"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome(""));
        System.out.println(isPalindrome("abcbaa"));
        System.out.println(isPalindrome("abcddcbas"));
        System.out.println(isPalindrome("abab"));
        System.out.println(isPalindrome("ab"));
    }

    private static boolean isPalindrome(String text) {
        if(text == null) {
            throw new IllegalArgumentException("text is null");
        }
        int length = text.length();
        for (int i = 0; i < length/2; i++) {
            int j = length - i - 1;
            if(text.charAt(i) != text.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}