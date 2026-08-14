class Solution { public: int timeRequiredToBuy(vector<int>& tickets,int k){int answer=0;for(int i=0;i<(int)tickets.size();++i)answer+=min(tickets[i],tickets[k]-(i>k));return answer;} };
