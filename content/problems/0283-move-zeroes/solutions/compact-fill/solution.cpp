class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int write = 0;
        for (int num : nums) if (num != 0) nums[write++] = num;
        while (write < (int)nums.size()) nums[write++] = 0;
    }
};
