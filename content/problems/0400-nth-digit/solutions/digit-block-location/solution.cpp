class Solution {
    public: int findNthDigit(int n){
        long long position=n,digit=1,start=1,count=9;
        while(position>digit*count){
            position-=digit*count;
            ++digit;
            start*=10;
            count*=10;
        }
        long long number=start+(position-1)/digit;
        return to_string(number)[(position-1)%digit]-'0';
    }
};
