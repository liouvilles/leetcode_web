class Solution {
    public:long long minCost(vector<int>& basket1,vector<int>& basket2){
        unordered_map<int,int> difference;
        int minimum=INT_MAX;
        for(int value:basket1){
            ++difference[value];
            minimum=min(minimum,value);
        }
        for(int value:basket2){
            --difference[value];
            minimum=min(minimum,value);
        }
        vector<int> first,second;
        for(auto [value,count]:difference){
            if(abs(count)%2)return -1;
            for(int i=0;i<count/2;++i)first.push_back(value);
            for(int i=0;i<-count/2;++i)second.push_back(value);
        }
        sort(first.begin(),first.end());
        sort(second.rbegin(),second.rend());
        long long cost=0;
        for(int i=0;i<(int)first.size();++i)cost+=min({
            1LL*first[i],1LL*second[i],2LL*minimum
        });
        return cost;
    }
};
