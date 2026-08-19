class Solution {
    public: vector<int> rearrangeBarcodes(vector<int>& barcodes){
        unordered_map<int,int> count;
        for(int value:barcodes)++count[value];
        priority_queue<pair<int,int>> heap;
        for(auto [value,frequency]:count)heap.push({
            frequency,-value
        });
        vector<int> answer;
        pair<int,int> previous{
            0,0
        };
        while(!heap.empty()){
            auto current=heap.top();
            heap.pop();
            answer.push_back(-current.second);
            --current.first;
            if(previous.first)heap.push(previous);
            previous=current;
        }
        return answer;
    }
};
