class Solution {
    public: bool isGoodArray(vector<int>& nums){
        int value=0;
        for(int number:nums){
            value=gcd(value,number);
            if(value==1)return true;
        }
        return false;
    }
};
