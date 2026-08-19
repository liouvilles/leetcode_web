class Solution {
    public:int minimumRounds(vector<int>& tasks){
        unordered_map<int,int> count;
        for(int task:tasks)++count[task];
        int answer=0;
        for(auto [_,value]:count){
            if(value==1)return -1;
            answer+=(value+2)/3;
        }
        return answer;
    }
};
