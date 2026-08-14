class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        int length = 1;
        for (int index = 1; index < (int)nums.size(); ++index) if (nums[index] != nums[length - 1]) nums[length++] = nums[index];
        return length;
    }
};
