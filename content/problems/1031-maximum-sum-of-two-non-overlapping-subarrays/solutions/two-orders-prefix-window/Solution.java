class Solution {
    public int maxSumTwoNoOverlap(int[] nums,int firstLen,int secondLen){
        int[] prefix=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)prefix[i+1]=prefix[i]+nums[i];
        return Math.max(order(prefix,firstLen,secondLen),order(prefix,secondLen,firstLen));
    }
    private int order(int[] prefix,int leftLength,int rightLength){
        int bestLeft=0,answer=0;
        for(int start=leftLength;start+rightLength<prefix.length;start++){
            bestLeft=Math.max(bestLeft,prefix[start]-prefix[start-leftLength]);
            answer=Math.max(answer,bestLeft+prefix[start+rightLength]-prefix[start]);
        }
        return answer;
    }
}
