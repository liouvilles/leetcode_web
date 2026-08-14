class Solution {
public:
    vector<vector<int>> generate(int numRows) { vector<vector<int>> answer; for (int row = 0; row < numRows; ++row) { vector<int> current(row + 1, 1); for (int column = 1; column < row; ++column) current[column] = answer[row - 1][column - 1] + answer[row - 1][column]; answer.push_back(current); } return answer; }
};
