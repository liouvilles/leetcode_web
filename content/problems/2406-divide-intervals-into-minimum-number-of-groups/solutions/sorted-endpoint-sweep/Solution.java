class Solution {
    public int minGroups(int[][] intervals){
        int n=intervals.length;
        int[] starts=new int[n],ends=new int[n];
        for(int i=0;i<n;i++){
            starts[i]=intervals[i][0];
            ends[i]=intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int i=0,j=0,active=0,answer=0;
        while(i<n){
            if(starts[i]<=ends[j]){
                active++;
                answer=Math.max(answer,active);
                i++;
            }else{
                active--;
                j++;
            }
        }
        return answer;
    }
}
