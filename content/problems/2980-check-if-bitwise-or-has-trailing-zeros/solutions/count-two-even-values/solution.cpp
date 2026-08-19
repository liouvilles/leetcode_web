class Solution { public:bool hasTrailingZeros(vector<int>& nums){int even=0;for(int value:nums)if(!(value&1)&&++even==2)return true;return false;} };
