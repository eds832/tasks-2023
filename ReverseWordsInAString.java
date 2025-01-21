public class ReverseWordsInAString {

    public static void main(String[] args) {
        System.out.println(
                new ReverseWordsInAString.Solution().reverseWords(" a good   example "));
    }

    /*
    Given an input string s, reverse the order of the words.
    A word is defined as a sequence of non-space characters.
    The words in s will be separated by at least one space.
    Return a string of the words in reverse order concatenated by a single space.
     */
    static class Solution {
        public String reverseWords(String s) {
            String[] ar = s.trim().split("\\s+");
            for (int i = 0, j = ar.length - 1; i < j; i++, j--) {
                String t = ar[i];
                ar[i] = ar[j];
                ar[j] = t;
            }
            return String.join(" ", ar);
        }
    }
}
