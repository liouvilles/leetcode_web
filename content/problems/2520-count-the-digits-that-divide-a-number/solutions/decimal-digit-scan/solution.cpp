class Solution {
    public:int countDigits(int num){
        int value=num,answer=0;
        while(value){
            int digit=value%10;
            if(digit&&num%digit==0)++answer;
            value/=10;
        }
        return answer;
    }
};
