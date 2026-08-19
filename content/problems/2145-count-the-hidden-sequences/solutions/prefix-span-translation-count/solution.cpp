class Solution {
    public:int numberOfArrays(vector<int>& differences,int lower,int upper){
        long long prefix=0,minimum=0,maximum=0;
        for(int difference:differences){
            prefix+=difference;
            minimum=min(minimum,prefix);
            maximum=max(maximum,prefix);
        }
        return max(0LL,(long long)upper-lower-(maximum-minimum)+1);
    }
};
