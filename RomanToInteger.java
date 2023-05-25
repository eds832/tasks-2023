public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        int num = 0;
        char prev = 'a';
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    if (prev == 'C') {
                        num += 800;
                    } else {
                        num += 1000;
                    }
                    prev = 'M';
                    break;
                case 'D':
                    if (prev == 'C') {
                        num += 300;
                    } else {
                        num += 500;
                    }
                    prev = 'D';
                    break;
                case 'C':
                    if (prev == 'X') {
                        num += 80;
                    } else {
                        num += 100;
                    }
                    prev = 'C';
                    break;
                case 'L':
                    if (prev == 'X') {
                        num += 30;
                    } else {
                        num += 50;
                    }
                    prev = 'X';
                    break;
                case 'X':
                    if (prev == 'I') {
                        num += 8;
                    } else {
                        num += 10;
                    }
                    prev = 'X';
                    break;
                case 'V':
                    if (prev == 'I') {
                        num += 3;
                    } else {
                        num += 5;
                    }
                    break;
                case 'I':
                    num += 1;
                    prev = 'I';
                    break;
            }
        }
        return num;
    }
}