class Solution {
    private int beauty(int[] frequency,int x){
        int count=0;
        for(int index=0;index<50;index++){
            count+=frequency[index];
            if(count>=x)return index-50;
        }
        return 0;
    }
    public int[] getSubarrayBeauty(int[] nums,int k,int x){
        int[] frequency=new int[101],answer=new int[nums.length-k+1];
        for(int i=0;i<k;i++)frequency[nums[i]+50]++;
        for(int start=0;start<answer.length;start++){
            answer[start]=beauty(frequency,x);
            frequency[nums[start]+50]--;
            if(start+k<nums.length)frequency[nums[start+k]+50]++;
        }
        return answer;
    }
}
