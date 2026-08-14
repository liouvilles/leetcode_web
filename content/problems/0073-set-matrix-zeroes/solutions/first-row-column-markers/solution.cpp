class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        bool firstRowZero = false, firstColumnZero = false;
        for (int value : matrix[0]) if (value == 0) firstRowZero = true;
        for (const auto& row : matrix) if (row[0] == 0) firstColumnZero = true;
        for (int row = 1; row < (int)matrix.size(); ++row) for (int column = 1; column < (int)matrix[0].size(); ++column) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0; }
        for (int row = 1; row < (int)matrix.size(); ++row) for (int column = 1; column < (int)matrix[0].size(); ++column) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
        if (firstRowZero) fill(matrix[0].begin(), matrix[0].end(), 0);
        if (firstColumnZero) for (auto& row : matrix) row[0] = 0;
    }
};
