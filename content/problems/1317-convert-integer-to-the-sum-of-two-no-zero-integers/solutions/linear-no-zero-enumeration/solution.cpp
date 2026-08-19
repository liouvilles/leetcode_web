class Solution {
    bool noZero(int value){
        while(value){
            if(value%10==0)return false;
            value/=10;
        }
        return true;
    }
    public:vector<int> getNoZeroIntegers(int n){
        for(int a=1;a<n;++a)if(noZero(a)&&noZero(n-a))return {
            a,n-a
        };
        return {
        };
    }
};
