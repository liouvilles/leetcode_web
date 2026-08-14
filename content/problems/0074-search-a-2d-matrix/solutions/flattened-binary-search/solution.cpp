class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int columns = matrix[0].size(), left = 0, right = matrix.size() * columns - 1;
        while (left <= right) { int middle = left + (right - left) / 2; int value = matrix[middle / columns][middle % columns]; if (value == target) return true; if (value < target) left = middle + 1; else right = middle - 1; }
        return false;
    }
};
