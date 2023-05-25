public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        return sb.toString().equals(sb.reverse().toString());
    }
}