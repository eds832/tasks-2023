/**
 * @author Eduard_Sardyka
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(1234567899));
    }

    /**
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1],
     * then return 0.
     */
    public static int reverse(int x) {
        boolean sign = false;
        long result = 0;
        long num = x;
        if (num < 0) {
            sign = true;
            num = -num;
        }
        while (num != 0) {
            result = result * 10;
            result = result + num % 10;
            num = num / 10;
        }
        if (sign) {
            result = -result;
        }
        if (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) {
            return (int) result;
        } else {
            return 0;
        }
    }
}