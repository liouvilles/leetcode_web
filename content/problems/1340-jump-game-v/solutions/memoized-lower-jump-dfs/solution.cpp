class Solution {
    vector<int> arr,memo;
    int d;
    int dfs(int index){
        if(memo[index])return memo[index];
        int best=1;
        for(int direction:{
            -1,1
        })for(int step=1;step<=d;++step){
            int next=index+direction*step;
            if(next<0||next>=(int)arr.size()||arr[next]>=arr[index])break;
            best=max(best,1+dfs(next));
        }
        return memo[index]=best;
    }
    public:int maxJumps(vector<int>& input,int distance){
        arr=input;
        d=distance;
        memo.assign(arr.size(),0);
        int answer=0;
        for(int i=0;i<(int)arr.size();++i)answer=max(answer,dfs(i));
        return answer;
    }
};
