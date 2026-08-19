class Solution {
    public int countWays(int[][] ranges){
        Arrays.sort(ranges,Comparator.comparingInt(a->a[0]));
        int components=0,end=-1;
        for(int[] range:ranges){
            if(range[0]>end){
                components++;
                end=range[1];
            }else end=Math.max(end,range[1]);
        }
        long answer=1;
        while(components-->0)answer=answer*2%1_000_000_007;
        return (int)answer;
    }
}
