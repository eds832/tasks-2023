public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix.Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefix.Solution().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    static class Solution {
        /*
        Write a function to find the longest common prefix string amongst an array of strings.
        If there is no common prefix, return an empty string "".
         */
        public String longestCommonPrefix(String[] strs) {
            String s1 = strs[0];
            StringBuilder sb = new StringBuilder(s1.length());
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                boolean append = true;
                for (int j = 1; j < strs.length; j++) {
                    String sj = strs[j];
                    if (sj.length() <= sb.length()) {
                        append = false;
                        break;
                    } else {
                        char cj = sj.charAt(i);
                        if (cj != c1) {
                            append = false;
                            break;
                        }
                    }
                }
                if (append) {
                    sb.append(c1);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }
    }
}
