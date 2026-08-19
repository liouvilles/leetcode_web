class Solution {
    public:long long kSum(vector<int>& nums,int k){
        long long maximum=0;
        vector<long long> values;
        for(int value:nums){
            if(value>0)maximum+=value;
            values.push_back(abs((long long)value));
        }
        sort(values.begin(),values.end());
        if(k==1)return maximum;
        using State=pair<long long,int>;
        priority_queue<State,vector<State>,greater<State>> heap;
        heap.push({
            values[0],0
        });
        long long loss=0;
        for(int rank=2;rank<=k;++rank){
            auto [sum,index]=heap.top();
            heap.pop();
            loss=sum;
            if(index+1<(int)values.size()){
                heap.push({
                    sum+values[index+1],index+1
                });
                heap.push({
                    sum-values[index]+values[index+1],index+1
                });
            }
        }
        return maximum-loss;
    }
};
