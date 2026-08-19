class Solution {
    public: int findLucky(vector<int>& arr){
        unordered_map<int,int> count;
        for(int value:arr)++count[value];
        int answer=-1;
        for(auto [value,frequency]:count)if(value==frequency)answer=max(answer,value);
        return answer;
    }
};
