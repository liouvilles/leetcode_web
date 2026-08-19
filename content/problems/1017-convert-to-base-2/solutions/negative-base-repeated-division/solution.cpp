class Solution {
    public: string baseNeg2(int n){
        if(n==0)return "0";
        string answer;
        while(n){
            int bit=n&1;
            answer+=char('0'+bit);
            n=(n-bit)/-2;
        }
        reverse(answer.begin(),answer.end());
        return answer;
    }
};
