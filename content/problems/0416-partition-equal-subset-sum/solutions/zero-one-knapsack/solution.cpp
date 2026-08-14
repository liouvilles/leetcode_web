class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(), 0); if (sum & 1) return false;
        int target = sum / 2; vector<bool> possible(target + 1); possible[0] = true;
        for (int value : nums) for (int current = target; current >= value; --current) possible[current] = possible[current] || possible[current - value];
        return possible[target];
    }
};
