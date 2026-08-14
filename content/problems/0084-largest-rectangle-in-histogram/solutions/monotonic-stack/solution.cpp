class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> stack = {-1};
        int best = 0;
        for (int index = 0; index <= (int)heights.size(); ++index) {
            int height = index == (int)heights.size() ? 0 : heights[index];
            while (stack.back() != -1 && heights[stack.back()] > height) { int rectangleHeight = heights[stack.back()]; stack.pop_back(); best = max(best, rectangleHeight * (index - stack.back() - 1)); }
            stack.push_back(index);
        }
        return best;
    }
};
