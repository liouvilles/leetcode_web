class Solution {
    vector<int> parent;
    int find(int value){
        return value==parent[value]?value:parent[value]=find(parent[value]);
    }
    void unite(int a,int b){
        parent[find(a)]=find(b);
    }
    public: bool gcdSort(vector<int>& nums){
        int maximum=*max_element(nums.begin(),nums.end());
        parent.resize(maximum+1);
        iota(parent.begin(),parent.end(),0);
        for(int value:nums){
            int remaining=value;
            for(int factor=2;factor*factor<=remaining;++factor)if(remaining%factor==0){
                unite(value,factor);
                while(remaining%factor==0)remaining/=factor;
            }
            if(remaining>1)unite(value,remaining);
        }
        vector<int> sorted=nums;
        sort(sorted.begin(),sorted.end());
        for(int i=0;i<(int)nums.size();++i)if(find(nums[i])!=find(sorted[i]))return false;
        return true;
    }
};
