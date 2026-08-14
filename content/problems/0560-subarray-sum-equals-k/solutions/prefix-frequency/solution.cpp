class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> counts{{0, 1}}; int prefix = 0, answer = 0;
        for (int value : nums) { prefix += value; answer += counts[prefix - k]; ++counts[prefix]; }
        return answer;
    }
};
