import java.util.LinkedList;
/**
 * @author Eduard_Sardyka
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }

    static class Solution {
        /**
         * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
         * determine if the input string is valid.
         * An input string is valid if:
         * Open brackets must be closed by the same type of brackets.
         * Open brackets must be closed in the correct order.
         * Every close bracket has a corresponding open bracket of the same type.
         * Input: s = "()[]{}"
         * Output: true
         * Constraints:
         * 1 <= s.length <= 10^4
         * s consists of parentheses only '()[]{}'.
         */
        public boolean isValid(String s) {
            if(s.length() % 2 != 0) {
                return false;
            }
            LinkedList<Character> linkedList = new LinkedList<>();
            int length = s.length();
            for(int i = 0; i < length; i++) {
                char c = s.charAt(i);
                switch(c) {
                    case '{':
                    case '(':
                    case '[':
                        // using as a stack
                        linkedList.push(c);
                        break;
                    case ')':
                        if(linkedList.isEmpty() || linkedList.pop() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if(linkedList.isEmpty() || linkedList.pop() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if(linkedList.isEmpty() || linkedList.pop() != '{') {
                            return false;
                        }
                        break;
                }
            }
            return linkedList.isEmpty();
        }
    }
}