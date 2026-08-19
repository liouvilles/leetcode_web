class Solution {
    public: vector<int> deckRevealedIncreasing(vector<int>& deck){
        sort(deck.begin(),deck.end());
        vector<int> answer(deck.size());
        queue<int> indices;
        for(int i=0;i<(int)deck.size();++i)indices.push(i);
        for(int value:deck){
            int index=indices.front();
            indices.pop();
            answer[index]=value;
            if(!indices.empty()){
                indices.push(indices.front());
                indices.pop();
            }
        }
        return answer;
    }
};
