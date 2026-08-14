class Solution { public: int arraySign(vector<int>& nums){int sign=1;for(int value:nums){if(!value)return 0;if(value<0)sign=-sign;}return sign;} };
