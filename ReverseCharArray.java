import java.util.Arrays;

public class ReverseCharArray {

    public static void main(String[] args) {
        char[] chars = new char[] {'a', 'b', 'c'};
        chars = reverseArray(chars);
        System.out.println(java.util.Arrays.toString(chars));

        //test it
        chars = new char[] {'a', 'b', 'c'};
        chars = reverseArray(chars);
        System.out.println(Arrays.equals(chars, new char[]{'c', 'b', 'a'}));

        try {
            reverseArray(null);
        } catch (RuntimeException ex){
            System.out.println(ex.getMessage().equals("null arg provided"));
        }
    }

    private static char[] reverseArray(char[] chars) {
        if(chars == null) throw new RuntimeException("null arg provided");
        int run = chars.length / 2;
        char toExchange;
        for (int i = 0; i < run; i++) {
            toExchange = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = toExchange;
        }
        return chars;
    }
}
