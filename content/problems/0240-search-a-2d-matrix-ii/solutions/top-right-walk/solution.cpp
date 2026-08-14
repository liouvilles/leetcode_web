class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = 0, column = matrix[0].size() - 1;
        while (row < (int)matrix.size() && column >= 0) { int value = matrix[row][column]; if (value == target) return true; if (value > target) --column; else ++row; }
        return false;
    }
};
