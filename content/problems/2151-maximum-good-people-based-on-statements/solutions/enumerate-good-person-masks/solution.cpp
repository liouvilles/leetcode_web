class Solution {
    public:int maximumGood(vector<vector<int>>& statements){
        int n=statements.size(),answer=0;
        for(int mask=0;mask<(1<<n);++mask){
            bool valid=true;
            for(int i=0;i<n&&valid;++i)if(mask>>i&1)for(int j=0;j<n;++j)if(statements[i][j]!=2&&statements[i][j]!=(mask>>j&1)){
                valid=false;
                break;
            }
            if(valid)answer=max(answer,__builtin_popcount(mask));
        }
        return answer;
    }
};
