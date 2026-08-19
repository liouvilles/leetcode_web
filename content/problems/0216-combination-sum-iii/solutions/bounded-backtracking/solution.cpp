class Solution {
    void dfs(int start,int k,int remaining,vector<int>& path,vector<vector<int>>& answer){
        if((int)path.size()==k){
            if(remaining==0)answer.push_back(path);
            return;
        }
        for(int value=start;value<=9&&value<=remaining;++value){
            path.push_back(value);
            dfs(value+1,k,remaining-value,path,answer);
            path.pop_back();
        }
    }
    public:vector<vector<int>> combinationSum3(int k,int n){
        vector<vector<int>> answer;
        vector<int> path;
        dfs(1,k,n,path,answer);
        return answer;
    }
};
