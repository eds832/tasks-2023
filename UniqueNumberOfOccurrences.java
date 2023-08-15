/**
 * @author Eduard_Sardyka
 */
class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
    }

    static class Solution {
        /**
         * https://leetcode.com/problems/unique-number-of-occurrences/
         * Given an array of integers arr, return true if the number
         * of occurrences of each value in the array is unique or false otherwise.
         * Example 1:
         * Input: arr = [1,2,2,1,1,3]
         * Output: true
         * Constraints:
         * 1 <= arr.length <= 1000
         * -1000 <= arr[i] <= 1000
         */
        public boolean uniqueOccurrences(int[] arr) {
            int[] keys = new int[arr.length];
            int[] values = new int[arr.length];
            int maxIndex = -1;
            for(int val: arr) {
                int index = indexOf(val, keys, maxIndex);
                if(index < 0) {
                    maxIndex++;
                    keys[maxIndex] = val;
                    values[maxIndex] = 1;
                } else {
                    values[index] = values[index] + 1;
                }
            }
            int[] check = new int[maxIndex + 1];
            int maxCheck = -1;
            for(int i = 0; i <= maxIndex; i++) {
                int val = values[i];
                if(indexOf(val, check, maxCheck) >= 0) {
                    return false;
                } else {
                    maxCheck++;
                    check[maxCheck] = val;
                }
            }
            return true;
        }

        public static int indexOf(int val, int[] arr, int maxIndex) {
            for (int i = 0; i <= maxIndex; i++) {
                if (val == arr[i]) return i;
            }
            return -1;
        }
    }

}
