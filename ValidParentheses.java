import java.util.LinkedList;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            if(s.length() % 2 != 0) {
                return false;
            }
            LinkedList<Character> linkedList = new LinkedList<>();
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch(c) {
                    case '{':
                    case '(':
                    case '[':
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