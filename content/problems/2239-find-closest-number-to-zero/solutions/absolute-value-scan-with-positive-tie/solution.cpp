class Solution { public:int findClosestNumber(vector<int>& nums){int answer=nums[0];for(int value:nums)if(abs(value)<abs(answer)||abs(value)==abs(answer)&&value>answer)answer=value;return answer;} };
