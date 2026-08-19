class Solution {
    public:int countHillValley(vector<int>& nums){
        vector<int> values;
        for(int value:nums)if(values.empty()||values.back()!=value)values.push_back(value);
        int answer=0;
        for(int i=1;i+1<(int)values.size();++i)if(values[i]>values[i-1]&&values[i]>values[i+1]||values[i]<values[i-1]&&values[i]<values[i+1])++answer;
        return answer;
    }
};
