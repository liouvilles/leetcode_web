class Solution {
    public: int countHomogenous(string text){
        const int MOD=1000000007;
        long long answer=0,run=0;
        for(int i=0;i<(int)text.size();++i){
            run=i&&text[i]==text[i-1]?run+1:1;
            answer=(answer+run)%MOD;
        }
        return answer;
    }
};
