class Solution {
    public: int countDigitOne(int n){
        long long answer=0;
        for(long long factor=1;factor<=n;factor*=10){
            long long high=n/(factor*10),current=n/factor%10,low=n%factor;
            answer+=high*factor;
            if(current==1)answer+=low+1;
            else if(current>1)answer+=factor;
        }
        return answer;
    }
};
