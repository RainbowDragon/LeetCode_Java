/*

LC435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new IntervalComparator());

        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++)
        {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    class IntervalComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }
}