class Solution { public:int averageValue(vector<int>& nums){int sum=0,count=0;for(int value:nums)if(value%6==0){sum+=value;++count;}return count?sum/count:0;} };
