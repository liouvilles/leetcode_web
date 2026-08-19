class Solution {
    public:vector<int> maxScoreIndices(vector<int>& nums){
        int score=accumulate(nums.begin(),nums.end(),0),maximum=-1;
        vector<int> answer;
        for(int split=0;split<=(int)nums.size();++split){
            if(score>maximum){
                maximum=score;
                answer={
                    split
                };
            }else if(score==maximum)answer.push_back(split);
            if(split<(int)nums.size())score+=nums[split]? -1:1;
        }
        return answer;
    }
};
