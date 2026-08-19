class Solution {
    public: int findLongestChain(vector<vector<int>>& pairs){
        sort(pairs.begin(),pairs.end(),[](auto& a,auto& b){
            return a[1]<b[1];
        });
        int end=INT_MIN,length=0;
        for(auto& pair:pairs)if(pair[0]>end){
            ++length;
            end=pair[1];
        }
        return length;
    }
};
