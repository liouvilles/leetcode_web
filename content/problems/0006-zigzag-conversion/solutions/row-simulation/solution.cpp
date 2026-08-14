class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1 || numRows >= (int)s.size()) return s;
        vector<string> rows(numRows); int row = 0, step = 1;
        for (char value : s) { rows[row] += value; if (row == 0) step = 1; else if (row == numRows - 1) step = -1; row += step; }
        return accumulate(rows.begin(), rows.end(), string());
    }
};
