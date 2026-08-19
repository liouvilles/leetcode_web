class Solution {
    int mapped(int value,vector<int>& mapping){
        if(!value)return mapping[0];
        int result=0,place=1;
        while(value){
            result+=mapping[value%10]*place;
            place*=10;
            value/=10;
        }
        return result;
    }
    public:vector<int> sortJumbled(vector<int>& mapping,vector<int>& nums){
        vector<int> order(nums.size()),values(nums.size());
        iota(order.begin(),order.end(),0);
        for(int i=0;i<(int)nums.size();++i)values[i]=mapped(nums[i],mapping);
        stable_sort(order.begin(),order.end(),[&](int a,int b){
            return values[a]<values[b];
        });
        vector<int> answer;
        for(int index:order)answer.push_back(nums[index]);
        return answer;
    }
};
