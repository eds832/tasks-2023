
/**
 * @author Eduard_Sardyka
 */
public class RearrangeSpacesBetweenWords {

    public static void main(String[] args) {
        System.out.println(new Solution().reorderSpaces(" practice   makes   perfect"));
    }

    static class Solution {
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
                sb.append(words[i].trim());
            }
            return sb.toString() + adSp;
        }
    }
}