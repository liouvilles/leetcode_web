class Solution {
    int power(int base,int exponent){
        int result=1;
        while(exponent--)result*=base;
        return result;
    }
    public:int atMostNGivenDigitSet(vector<string>& digits,int n){
        string text=to_string(n);
        int base=digits.size(),answer=0;
        for(int length=1;length<(int)text.size();++length)answer+=power(base,length);
        for(int i=0;i<(int)text.size();++i){
            int less=0;
            bool equal=false;
            for(string& digit:digits)if(digit[0]<text[i])++less;
            else if(digit[0]==text[i])equal=true;
            answer+=less*power(base,text.size()-1-i);
            if(!equal)return answer;
        }
        return answer+1;
    }
};
