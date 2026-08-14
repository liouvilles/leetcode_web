class Solution {
public:
    int singleNumber(vector<int>& nums) { int ones = 0, twos = 0; for (int value : nums) { ones = (ones ^ value) & ~twos; twos = (twos ^ value) & ~ones; } return ones; }
};
