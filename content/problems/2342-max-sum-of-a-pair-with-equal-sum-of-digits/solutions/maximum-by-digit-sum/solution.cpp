class Solution {
    int digitSum(int value){
        int sum=0;
        while(value){
            sum+=value%10;
            value/=10;
        }
        return sum;
    }
    public:int maximumSum(vector<int>& nums){
        unordered_map<int,int> maximum;
        int answer=-1;
        for(int value:nums){
            int sum=digitSum(value);
            if(maximum.count(sum))answer=max(answer,value+maximum[sum]);
            maximum[sum]=max(maximum[sum],value);
        }
        return answer;
    }
};
