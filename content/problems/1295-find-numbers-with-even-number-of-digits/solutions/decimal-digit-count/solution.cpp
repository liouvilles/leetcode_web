class Solution {
    public: int findNumbers(vector<int>& nums){
        int answer=0;
        for(int value:nums){
            int digits=0;
            for(int number=value;number;number/=10)++digits;
            if(digits%2==0)++answer;
        }
        return answer;
    }
};
