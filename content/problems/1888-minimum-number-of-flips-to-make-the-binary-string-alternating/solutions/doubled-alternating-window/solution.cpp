class Solution {
    public: int minFlips(string s){
        int n=s.size(),zero=0,one=0,answer=n;
        for(int i=0;i<2*n;++i){
            char value=s[i%n],expectedZero=i%2?'1':'0';
            if(value!=expectedZero)++zero;
            else ++one;
            if(i>=n){
                int old=i-n;
                char oldValue=s[old%n],oldExpected=old%2?'1':'0';
                if(oldValue!=oldExpected)--zero;
                else --one;
            }
            if(i>=n-1)answer=min({
                answer,zero,one
            });
        }
        return answer;
    }
};
