class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> answer;
        for (int first = 0; first + 2 < (int)nums.size(); ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            if (nums[first] > 0) break;
            int left = first + 1, right = (int)nums.size() - 1;
            while (left < right) {
                int sum = nums[first] + nums[left] + nums[right];
                if (sum < 0) ++left;
                else if (sum > 0) --right;
                else {
                    answer.push_back({nums[first], nums[left], nums[right]});
                    int leftValue = nums[left], rightValue = nums[right];
                    while (left < right && nums[left] == leftValue) ++left;
                    while (left < right && nums[right] == rightValue) --right;
                }
            }
        }
        return answer;
    }
};
