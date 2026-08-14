class Solution {
public:
    int numSquares(int n) {
        vector<int> count(n + 1, n + 1); count[0] = 0;
        for (int value = 1; value <= n; ++value) for (int root = 1; root * root <= value; ++root) count[value] = min(count[value], count[value - root * root] + 1);
        return count[n];
    }
};
