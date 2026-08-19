class Solution {
    public: vector<int> minOperations(string boxes){
        vector<int> answer(boxes.size());
        int balls=0,cost=0;
        for(int i=0;i<(int)boxes.size();++i){
            answer[i]+=cost;
            if(boxes[i]=='1')++balls;
            cost+=balls;
        }
        balls=cost=0;
        for(int i=boxes.size()-1;i>=0;--i){
            answer[i]+=cost;
            if(boxes[i]=='1')++balls;
            cost+=balls;
        }
        return answer;
    }
};
