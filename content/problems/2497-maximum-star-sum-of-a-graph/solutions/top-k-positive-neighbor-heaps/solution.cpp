class Solution {
    public:int maxStarSum(vector<int>& vals,vector<vector<int>>& edges,int k){
        vector<priority_queue<int,vector<int>,greater<int>>> heaps(vals.size());
        auto add=[&](int node,int value){
            if(value<=0||k==0)return;
            heaps[node].push(value);
            if((int)heaps[node].size()>k)heaps[node].pop();
        };
        for(auto& edge:edges){
            add(edge[0],vals[edge[1]]);
            add(edge[1],vals[edge[0]]);
        }
        int answer=INT_MIN;
        for(int node=0;node<(int)vals.size();++node){
            int sum=vals[node];
            while(!heaps[node].empty()){
                sum+=heaps[node].top();
                heaps[node].pop();
            }
            answer=max(answer,sum);
        }
        return answer;
    }
};
