class Solution {
    public int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals,Comparator.comparingInt(a->a[1]));
        int end=Integer.MIN_VALUE,removed=0;
        for(int[] interval:intervals){
            if(interval[0]>=end)end=interval[1];
            else removed++;
        }
        return removed;
    }
}
