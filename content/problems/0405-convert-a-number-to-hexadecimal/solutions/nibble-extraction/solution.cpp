class Solution {
    public: string toHex(int num){
        if(num==0)return "0";
        string digits="0123456789abcdef",answer;
        unsigned value=num;
        while(value){
            answer+=digits[value&15];
            value>>=4;
        }
        reverse(answer.begin(),answer.end());
        return answer;
    }
};
