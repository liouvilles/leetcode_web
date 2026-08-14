class Solution {
public:
    int jump(vector<int>& nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int index = 0; index + 1 < (int)nums.size(); ++index) { farthest = max(farthest, index + nums[index]); if (index == currentEnd) { ++jumps; currentEnd = farthest; } }
        return jumps;
    }
};
