import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] ar = new MergeIntervals.Solution().merge(
                new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 6},
                        new int[]{8, 10},
                        new int[]{15, 18}
                });
        Arrays.stream(ar).map(Arrays::toString).forEach(System.out::println);
    }

    static class Solution {
        /*
        Given an array of intervals where intervals[i] = [starti, endi],
        merge all overlapping intervals,
        and return an array of the non-overlapping intervals
        that cover all the intervals in the input.
         */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (ar1, ar2) -> ar1[0] - ar2[0]);
            List<int[]> list = new ArrayList<>();
            int start = intervals[0][0];
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (end >= intervals[i][0]) {
                    start = Math.min(start, intervals[i][0]);
                    end = Math.max(end, intervals[i][1]);
                } else {
                    list.add(new int[]{start, end});
                    start = intervals[i][0];
                    end = intervals[i][1];
                }
            }
            list.add(new int[]{start, end});
            return list.toArray(new int[list.size()][]);
        }
    }
}
