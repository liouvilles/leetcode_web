class Solution {
    public: int consecutiveNumbersSum(int n){
        int answer=0;
        for(long long length=1;length*(length-1)/2<n;++length)if((n-length*(length-1)/2)%length==0)++answer;
        return answer;
    }
};
