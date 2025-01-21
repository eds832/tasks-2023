public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(new HappyNumber.Solution().isHappy(21));
        System.out.println(new HappyNumber.Solution().isHappy(8));
        System.out.println(new HappyNumber.Solution().isHappy(19));
    }

    static class Solution {
        /*
        Write an algorithm to determine if a number n is happy.
        A happy number is a number defined by the following process:
        Starting with any positive integer,
        replace the number by the sum of the squares of its digits.
        Repeat the process until the number equals 1 (where it will stay),
        or it loops endlessly in a cycle which does not include 1.
        Those numbers for which this process ends in 1 are happy.
        Return true if n is a happy number, and false if not.
         */
        public boolean isHappy(int n) {
            int sum = 0;
            int d = n;
            while(d != 0) {
                int el = d % 10;
                sum += el * el;
                d /= 10;
            }
            if(sum == 1) {
                return true;
            } else if(sum == 2 || sum == 5 || sum == 4) {
                return false;
            } else {
                return isHappy(sum);
            }
        }
    }
}
