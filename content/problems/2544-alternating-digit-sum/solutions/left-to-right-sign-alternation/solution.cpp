class Solution {
    public:int alternateDigitSum(int n){
        string digits=to_string(n);
        int answer=0;
        for(int i=0;i<(int)digits.size();++i)answer+=(i%2? -1:1)*(digits[i]-'0');
        return answer;
    }
};
