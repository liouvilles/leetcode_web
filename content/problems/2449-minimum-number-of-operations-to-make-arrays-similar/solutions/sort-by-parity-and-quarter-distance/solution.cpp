class Solution {
    vector<int> group(vector<int>& values,int parity){
        vector<int> result;
        for(int value:values)if(value%2==parity)result.push_back(value);
        sort(result.begin(),result.end());
        return result;
    }
    public:long long makeSimilar(vector<int>& nums,vector<int>& target){
        long long difference=0;
        for(int parity=0;parity<2;++parity){
            auto a=group(nums,parity),b=group(target,parity);
            for(int i=0;i<(int)a.size();++i)difference+=llabs((long long)a[i]-b[i]);
        }
        return difference/4;
    }
};
