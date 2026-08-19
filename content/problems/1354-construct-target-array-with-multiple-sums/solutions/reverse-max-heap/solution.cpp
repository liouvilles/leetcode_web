class Solution {
    public: bool isPossible(vector<int>& target){
        priority_queue<long long> heap;
        long long total=0;
        for(int value:target){
            heap.push(value);
            total+=value;
        }while(true){
            long long maximum=heap.top();
            heap.pop();
            long long rest=total-maximum;
            if(maximum==1||rest==1)return true;
            if(rest==0||rest>=maximum||maximum%rest==0)return false;
            long long previous=maximum%rest;
            total=rest+previous;
            heap.push(previous);
        }
    }
};
