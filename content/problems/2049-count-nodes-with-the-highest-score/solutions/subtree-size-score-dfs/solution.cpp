class Solution {
    vector<vector<int>> children;
    int n,count=0;
    long long maximum=0;
    int dfs(int node){
        int size=1;
        long long score=1;
        for(int child:children[node]){
            int childSize=dfs(child);
            size+=childSize;
            score*=childSize;
        }
        if(n-size)score*=n-size;
        if(score>maximum){
            maximum=score;
            count=1;
        }else if(score==maximum)++count;
        return size;
    }
    public: int countHighestScoreNodes(vector<int>& parents){
        n=parents.size();
        children.resize(n);
        for(int i=1;i<n;++i)children[parents[i]].push_back(i);
        dfs(0);
        return count;
    }
};
