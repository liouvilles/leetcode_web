class Solution {
    public:int makeTheIntegerZero(int num1,int num2){
        for(int operations=1;operations<=60;++operations){
            long long target=(long long)num1-(long long)operations*num2;
            if(target>=operations&&__builtin_popcountll(target)<=operations)return operations;
        }
        return -1;
    }
};
