class Solution {
    public int getMaxLen(int[] nums){
        int positive=0,negative=0,answer=0;
        for(int value:nums){
            if(value>0){
                positive++;
                if(negative>0)negative++;
            }else if(value<0){
                int newPositive=negative>0?negative+1:0,newNegative=positive+1;
                positive=newPositive;
                negative=newNegative;
            }else positive=negative=0;
            answer=Math.max(answer,positive);
        }
        return answer;
    }
}
