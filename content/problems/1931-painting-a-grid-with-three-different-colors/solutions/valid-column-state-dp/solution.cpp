class Solution {
    public: int colorTheGrid(int m,int n){
        const long long MOD=1000000007;
        int limit=1;
        for(int i=0;i<m;++i)limit*=3;
        vector<int> states;
        for(int state=0;state<limit;++state){
            int value=state,previous=-1;
            bool valid=true;
            for(int row=0;row<m;++row){
                int color=value%3;
                value/=3;
                if(color==previous)valid=false;
                previous=color;
            }
            if(valid)states.push_back(state);
        }
        int size=states.size();
        vector<vector<bool>> compatible(size,vector<bool>(size,true));
        for(int i=0;i<size;++i)for(int j=0;j<size;++j){
            int a=states[i],b=states[j];
            for(int row=0;row<m;++row){
                if(a%3==b%3)compatible[i][j]=false;
                a/=3;
                b/=3;
            }
        }
        vector<long long> dp(size,1);
        for(int col=1;col<n;++col){
            vector<long long> next(size);
            for(int current=0;current<size;++current)for(int previous=0;previous<size;++previous)if(compatible[previous][current])next[current]=(next[current]+dp[previous])%MOD;
            dp.swap(next);
        }
        return accumulate(dp.begin(),dp.end(),0LL)%MOD;
    }
};
