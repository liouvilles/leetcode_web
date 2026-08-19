class Solution {
    public:int minimizeXor(int num1,int num2){
        int need=__builtin_popcount(num2),answer=0;
        for(int bit=30;bit>=0&&need;--bit)if(num1&(1<<bit)){
            answer|=1<<bit;
            --need;
        }
        for(int bit=0;bit<=30&&need;++bit)if(!(answer&(1<<bit))){
            answer|=1<<bit;
            --need;
        }
        return answer;
    }
};
