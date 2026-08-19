class Solution {
    public:int minOperations(vector<int>& nums,int k){
        priority_queue<long long,vector<long long>,greater<long long>> heap;
        for(int value:nums)heap.push(value);
        int operations=0;
        while(heap.top()<k){
            long long first=heap.top();
            heap.pop();
            long long second=heap.top();
            heap.pop();
            heap.push(first*2+second);
            ++operations;
        }
        return operations;
    }
};
