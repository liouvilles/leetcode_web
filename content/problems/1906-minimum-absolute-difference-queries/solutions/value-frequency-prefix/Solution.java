class Solution {
    public int[] minDifference(int[] nums,int[][] queries){
        int[][] prefix=new int[nums.length+1][101];
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i].clone();
            prefix[i+1][nums[i]]++;
        }
        int[] answer=new int[queries.length];
        for(int q=0;q<queries.length;q++){
            int previous=-1,best=101,left=queries[q][0],right=queries[q][1]+1;
            for(int value=1;value<=100;value++)if(prefix[right][value]>prefix[left][value]){
                if(previous!=-1)best=Math.min(best,value-previous);
                previous=value;
            }
            answer[q]=best==101?-1:best;
        }
        return answer;
    }
}
