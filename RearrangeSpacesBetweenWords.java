/**
 * @author Eduard_Sardyka
 */
public class RearrangeSpacesBetweenWords {

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces(" practice   makes   perfect"));
    }

    static class Solution {
        /**
         * You are given a string text of words that are placed among some number of spaces.
         * Each word consists of one or more lowercase
         * English letters and are separated by at least one space.
         * It's guaranteed that text contains at least one word.
         * Rearrange the spaces so that there is an equal number of spaces
         * between every pair of adjacent words and that number is maximized.
         * If you cannot redistribute all the spaces equally,
         * place the extra spaces at the end, meaning the returned string should be the same length as text.
         * Return the string after rearranging the spaces.
         * Example 1:
         * Input: text = "  this   is  a sentence "
         * Output: "this   is   a   sentence"
         * Constraints:
         * 1 <= text.length <= 100
         * text consists of lowercase English letters and ' '.
         * text contains at least one word.
         */
        public String reorderSpaces(String text) {

            String[] words = text.trim().split("\\s+");
            int totalWordsLength = 0;
            for (String word : words) {
                totalWordsLength += word.length();
            }
            int spacesLength = text.length() - totalWordsLength;
            int spaceLength = words.length != 1 ? spacesLength / (words.length - 1) : 0;
            int additionalSpaces = words.length != 1 ? spacesLength % (words.length - 1) : spacesLength;
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < spaceLength; i++) {
                space.append(" ");
            }
            String sp = space.toString();
            StringBuilder adSpace = new StringBuilder();
            for (int i = 0; i < additionalSpaces; i++) {
                adSpace.append(" ");
            }
            String adSp = adSpace.toString();
            StringBuilder sb = new StringBuilder(words[0]);
            for (int i = 1; i < words.length; i++) {
                sb.append(sp);
                sb.append(words[i]);
            }
            return sb.toString() + adSp;
        }
    }
}