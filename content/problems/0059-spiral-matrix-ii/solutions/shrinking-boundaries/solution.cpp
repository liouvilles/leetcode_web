class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> answer(n, vector<int>(n)); int top = 0, bottom = n - 1, left = 0, right = n - 1, value = 1;
        while (top <= bottom && left <= right) { for (int column = left; column <= right; ++column) answer[top][column] = value++; ++top; for (int row = top; row <= bottom; ++row) answer[row][right] = value++; --right; if (top <= bottom) { for (int column = right; column >= left; --column) answer[bottom][column] = value++; --bottom; } if (left <= right) { for (int row = bottom; row >= top; --row) answer[row][left] = value++; ++left; } } return answer;
    }
};
