class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> answer(nums.size(), 1);
        for (int index = 1; index < (int)nums.size(); ++index) answer[index] = answer[index - 1] * nums[index - 1];
        int suffix = 1;
        for (int index = nums.size() - 1; index >= 0; --index) { answer[index] *= suffix; suffix *= nums[index]; }
        return answer;
    }
};
