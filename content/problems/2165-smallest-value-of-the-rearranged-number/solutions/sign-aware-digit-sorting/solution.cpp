class Solution {
    public:long long smallestNumber(long long num){
        if(!num)return 0;
        string digits=to_string(llabs(num));
        sort(digits.begin(),digits.end());
        if(num>0){
            int first=digits.find_first_not_of('0');
            swap(digits[0],digits[first]);
            return stoll(digits);
        }
        reverse(digits.begin(),digits.end());
        return -stoll(digits);
    }
};
