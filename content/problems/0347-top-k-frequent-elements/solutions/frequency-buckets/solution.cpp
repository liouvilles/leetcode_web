class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> counts; vector<int> order;
        for (int value : nums) { if (!counts.count(value)) order.push_back(value); ++counts[value]; }
        vector<vector<int>> buckets(nums.size() + 1); for (int value : order) buckets[counts[value]].push_back(value);
        vector<int> answer; answer.reserve(k);
        for (int frequency = nums.size(); frequency > 0 && (int)answer.size() < k; --frequency) for (int value : buckets[frequency]) { if ((int)answer.size() < k) answer.push_back(value); }
        return answer;
    }
};
