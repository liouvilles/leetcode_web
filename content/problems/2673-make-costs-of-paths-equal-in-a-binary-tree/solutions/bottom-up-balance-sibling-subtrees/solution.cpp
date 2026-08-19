class Solution {
    public:int minIncrements(int n,vector<int>& cost){
        int answer=0;
        for(int node=n/2;node>=1;--node){
            int left=cost[2*node-1],right=cost[2*node];
            answer+=abs(left-right);
            cost[node-1]+=max(left,right);
        }
        return answer;
    }
};
