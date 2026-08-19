class Solution {
    public:vector<int> separateDigits(vector<int>& nums){
        vector<int> digits;
        for(int value:nums)for(char character:to_string(value))digits.push_back(character-'0');
        return digits;
    }
};
