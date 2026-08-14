class Solution { public:int minimumCost(vector<int>& cost){sort(cost.rbegin(),cost.rend());int answer=0;for(int i=0;i<(int)cost.size();++i)if(i%3!=2)answer+=cost[i];return answer;} };
