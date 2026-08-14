class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> tails;
        for (int value : nums) { auto position = lower_bound(tails.begin(), tails.end(), value); if (position == tails.end()) tails.push_back(value); else *position = value; }
        return tails.size();
    }
};
