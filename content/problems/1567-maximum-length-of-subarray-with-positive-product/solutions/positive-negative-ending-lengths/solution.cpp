class Solution {
    public: int getMaxLen(vector<int>& nums){
        int positive=0,negative=0,answer=0;
        for(int value:nums){
            if(value>0){
                ++positive;
                if(negative)++negative;
            }else if(value<0){
                int newPositive=negative?negative+1:0,newNegative=positive+1;
                positive=newPositive;
                negative=newNegative;
            }else positive=negative=0;
            answer=max(answer,positive);
        }
        return answer;
    }
};
