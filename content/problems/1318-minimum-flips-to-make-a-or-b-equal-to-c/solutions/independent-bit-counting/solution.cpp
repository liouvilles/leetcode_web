class Solution {
    public: int minFlips(int a,int b,int c){
        int answer=0;
        while(a||b||c){
            int bitA=a&1,bitB=b&1,bitC=c&1;
            if(bitC){
                if(!(bitA|bitB))++answer;
            }else answer+=bitA+bitB;
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return answer;
    }
};
