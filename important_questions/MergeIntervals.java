package important_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (next[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], next[1]);
            } else {
                res.add(cur);
                cur = next;
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] in = {{1,3},{2,6},{8,10},{15,18}};
        int[][] out = merge(in);
        System.out.print("Merged: ");
        for (int[] r : out) System.out.print(Arrays.toString(r) + " ");
        System.out.println();
    }
}
