class Solution {
    public: bool increasingTriplet(vector<int>& nums){
        int first=INT_MAX,second=INT_MAX;
        for(int value:nums){
            if(value<=first)first=value;
            else if(value<=second)second=value;
            else return true;
        }
        return false;
    }
};
