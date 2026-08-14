class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> answer; deque<int> candidates;
        for (int right = 0; right < (int)nums.size(); ++right) { while (!candidates.empty() && candidates.front() <= right - k) candidates.pop_front(); while (!candidates.empty() && nums[candidates.back()] <= nums[right]) candidates.pop_back(); candidates.push_back(right); if (right >= k - 1) answer.push_back(nums[candidates.front()]); }
        return answer;
    }
};
