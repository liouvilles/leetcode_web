class Solution {
    public:int minimumSum(int num){
        vector<int> digits(4);
        for(int& digit:digits){
            digit=num%10;
            num/=10;
        }
        sort(digits.begin(),digits.end());
        return 10*(digits[0]+digits[1])+digits[2]+digits[3];
    }
};
