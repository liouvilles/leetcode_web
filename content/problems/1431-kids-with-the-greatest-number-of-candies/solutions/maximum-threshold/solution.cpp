class Solution {
    public: vector<bool> kidsWithCandies(vector<int>& candies,int extraCandies){
        int maximum=*max_element(candies.begin(),candies.end());
        vector<bool> answer;
        for(int value:candies)answer.push_back(value+extraCandies>=maximum);
        return answer;
    }
};
