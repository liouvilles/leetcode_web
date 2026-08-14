class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for (int row = 0; row < n; ++row) for (int column = row + 1; column < n; ++column) swap(matrix[row][column], matrix[column][row]);
        for (auto& row : matrix) reverse(row.begin(), row.end());
    }
};
