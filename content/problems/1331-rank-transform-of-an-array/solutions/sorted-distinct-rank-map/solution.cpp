class Solution {
    public: vector<int> arrayRankTransform(vector<int>& arr){
        vector<int> sorted=arr;
        sort(sorted.begin(),sorted.end());
        unordered_map<int,int> ranks;
        for(int value:sorted)if(!ranks.count(value))ranks[value]=ranks.size()+1;
        for(int& value:arr)value=ranks[value];
        return arr;
    }
};
