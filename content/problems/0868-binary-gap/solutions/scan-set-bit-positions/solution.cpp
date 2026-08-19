class Solution {
    public: int binaryGap(int n){
        int answer=0,previous=-1,position=0;
        while(n){
            if(n&1){
                if(previous>=0)answer=max(answer,position-previous);
                previous=position;
            }
            n>>=1;
            ++position;
        }
        return answer;
    }
};
