class Solution {
    public:long long pickGifts(vector<int>& gifts,int k){
        priority_queue<int> heap(gifts.begin(),gifts.end());
        while(k--){
            int gift=heap.top();
            heap.pop();
            heap.push(sqrt(gift));
        }
        long long answer=0;
        while(!heap.empty()){
            answer+=heap.top();
            heap.pop();
        }
        return answer;
    }
};
