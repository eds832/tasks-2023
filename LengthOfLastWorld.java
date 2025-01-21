public class LengthOfLastWorld {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWorld.Solution().lengthOfLastWord("Hello World"));
        System.out.println(new LengthOfLastWorld.Solution().lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(new LengthOfLastWorld.Solution().lengthOfLastWord("luffy is still joyboy"));
    }

    static class Solution {
        /*
        Given a string s consisting of words and spaces, return the length of the last word in the string.
        A word is a maximal substring consisting of non-space characters only.
         */
        public int lengthOfLastWord(String s) {
            int count = 0;
            boolean started = false;
            for(int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if(c == ' ') {
                    if(started) {
                        return count;
                    }
                } else {
                    started = true;
                    count++;
                }
            }
            return count;
        }
    }
}
