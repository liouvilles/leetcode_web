class Solution {
public:
    bool canJump(vector<int>& nums) {
        int farthest = 0;
        for (int index = 0; index < (int)nums.size(); ++index) {
            if (index > farthest) return false;
            farthest = max(farthest, index + nums[index]);
            if (farthest >= (int)nums.size() - 1) return true;
        }
        return true;
    }
};
