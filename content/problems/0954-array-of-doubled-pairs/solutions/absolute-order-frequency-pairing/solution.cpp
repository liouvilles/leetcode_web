class Solution {
    public: bool canReorderDoubled(vector<int>& arr){
        unordered_map<int,int> count;
        for(int x:arr)++count[x];
        sort(arr.begin(),arr.end(),[](int a,int b){
            return abs(a)<abs(b);
        });
        for(int x:arr){
            if(count[x]==0)continue;
            if(count[2*x]==0)return false;
            --count[x];
            --count[2*x];
        }
        return true;
    }
};
