class Solution {
    bool prime(int value){
        if(value<2)return false;
        for(int divisor=2;(long long)divisor*divisor<=value;++divisor)if(value%divisor==0)return false;
        return true;
    }
    public:int primePalindrome(int n){
        if(n>=8&&n<=11)return 11;
        for(int prefix=1;;++prefix){
            string text=to_string(prefix),palindrome=text;
            for(int i=text.size()-2;i>=0;--i)palindrome+=text[i];
            int value=stoi(palindrome);
            if(value>=n&&prime(value))return value;
        }
    }
};
