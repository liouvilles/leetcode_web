class Solution {
    public: int sumFourDivisors(vector<int>& nums){
        int answer=0;
        for(int value:nums){
            int count=0,sum=0;
            for(int divisor=1;divisor*divisor<=value&&count<=4;++divisor)if(value%divisor==0){
                int other=value/divisor;
                ++count;
                sum+=divisor;
                if(other!=divisor){
                    ++count;
                    sum+=other;
                }
            }
            if(count==4)answer+=sum;
        }
        return answer;
    }
};
