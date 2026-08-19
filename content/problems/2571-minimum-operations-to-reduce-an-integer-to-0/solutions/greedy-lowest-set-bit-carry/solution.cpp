class Solution {
    public:int minOperations(int n){
        int operations=0;
        while(n){
            if((n&3)==3)++n;
            else n-=n&-n;
            ++operations;
        }
        return operations;
    }
};
