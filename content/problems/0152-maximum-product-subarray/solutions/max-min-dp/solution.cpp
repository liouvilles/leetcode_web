class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int currentMax = nums[0], currentMin = nums[0], answer = nums[0];
        for (int index = 1; index < (int)nums.size(); ++index) {
            int value = nums[index], previousMax = currentMax;
            currentMax = max({value, previousMax * value, currentMin * value});
            currentMin = min({value, previousMax * value, currentMin * value});
            answer = max(answer, currentMax);
        }
        return answer;
    }
};
