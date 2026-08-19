class Solution {
    public:int returnToBoundaryCount(vector<int>& nums){
        int position=0,answer=0;
        for(int distance:nums){
            position+=distance;
            if(position==0)++answer;
        }
        return answer;
    }
};
