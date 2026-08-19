class Solution {
    vector<int> factors(int value){
        vector<int> result;
        for(int factor=2;factor*factor<=value;++factor)if(value%factor==0){
            result.push_back(factor);
            while(value%factor==0)value/=factor;
        }
        if(value>1)result.push_back(value);
        return result;
    }
    public:int findValidSplit(vector<int>& nums){
        unordered_map<int,int> last;
        for(int i=0;i<(int)nums.size();++i)for(int factor:factors(nums[i]))last[factor]=i;
        int boundary=0;
        for(int i=0;i+1<(int)nums.size();++i){
            for(int factor:factors(nums[i]))boundary=max(boundary,last[factor]);
            if(i==boundary)return i;
        }
        return -1;
    }
};
