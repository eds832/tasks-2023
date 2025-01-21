public class FindIndexOfFirstOccurrenceInString {
    public static void main(String[] args) {
        System.out.println(new FindIndexOfFirstOccurrenceInString.Solution().strStr("sadbutsad", "sad"));
        System.out.println(new FindIndexOfFirstOccurrenceInString.Solution().strStr("leetcode", "leeto"));
    }

    static class Solution {
        /*
        Given two strings needle and haystack,
        return the index of the first occurrence of needle in haystack,
        or -1 if needle is not part of haystack.
         */
        public int strStr(String haystack, String needle) {
            int index = -1;
            for (int i = 0; i < haystack.length(); i++) {
                boolean found = true;
                for (int j = 0; j < needle.length(); j++) {
                    int k = i + j;
                    if (k > haystack.length() - 1 || needle.charAt(j) != haystack.charAt(k)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return i;
                }
            }
            return index;
        }
    }
}
