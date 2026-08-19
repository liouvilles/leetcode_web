class Solution {
    int permutation(int choices,int count){
        int result=1;
        for(int i=0;i<count;++i)result*=choices-i;
        return result;
    }
    public:int numDupDigitsAtMostN(int n){
        string digits=to_string(n);
        int unique=0;
        for(int length=1;length<(int)digits.size();++length)unique+=9*permutation(9,length-1);
        bool used[10]={
        };
        for(int i=0;i<(int)digits.size();++i){
            int current=digits[i]-'0',start=i==0?1:0;
            for(int digit=start;digit<current;++digit)if(!used[digit])unique+=permutation(9-i,digits.size()-i-1);
            if(used[current])return n-unique;
            used[current]=true;
        }
        return n-unique-1;
    }
};
