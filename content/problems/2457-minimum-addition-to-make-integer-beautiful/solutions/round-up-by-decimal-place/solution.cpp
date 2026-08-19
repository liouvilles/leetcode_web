class Solution {
    int digitSum(long long value){
        int sum=0;
        while(value){
            sum+=value%10;
            value/=10;
        }
        return sum;
    }
    public:long long makeIntegerBeautiful(long long n,int target){
        long long original=n,place=10;
        while(digitSum(n)>target){
            long long remainder=n%place;
            if(remainder)n+=place-remainder;
            place*=10;
        }
        return n-original;
    }
};
