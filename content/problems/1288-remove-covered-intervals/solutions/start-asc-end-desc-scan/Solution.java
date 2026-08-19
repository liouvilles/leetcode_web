class Solution {
    public int removeCoveredIntervals(int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[0]==b[0]?Integer.compare(b[1],a[1]):Integer.compare(a[0],b[0]));
        int maximumEnd=Integer.MIN_VALUE,remaining=0;
        for(int[] interval:intervals)if(interval[1]>maximumEnd){
            remaining++;
            maximumEnd=interval[1];
        }
        return remaining;
    }
}
