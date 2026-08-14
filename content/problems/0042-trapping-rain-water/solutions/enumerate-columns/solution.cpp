class Solution {
public:
    int trap(vector<int>& height) {
        int water = 0;
        for (int i = 1; i + 1 < (int)height.size(); ++i) {
            int leftMax = 0, rightMax = 0;
            for (int left = 0; left <= i; ++left) leftMax = max(leftMax, height[left]);
            for (int right = i; right < (int)height.size(); ++right) rightMax = max(rightMax, height[right]);
            water += min(leftMax, rightMax) - height[i];
        }
        return water;
    }
};
