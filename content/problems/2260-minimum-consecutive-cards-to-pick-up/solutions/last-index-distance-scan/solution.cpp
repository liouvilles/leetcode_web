class Solution {
    public:int minimumCardPickup(vector<int>& cards){
        unordered_map<int,int> last;
        int answer=INT_MAX;
        for(int i=0;i<(int)cards.size();++i){
            if(last.count(cards[i]))answer=min(answer,i-last[cards[i]]+1);
            last[cards[i]]=i;
        }
        return answer==INT_MAX?-1:answer;
    }
};
