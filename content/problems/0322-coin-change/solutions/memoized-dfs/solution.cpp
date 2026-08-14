class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> memo(amount + 1, -2);
        memo[0] = 0;
        function<int(int)> dfs = [&](int remain) {
            if (remain < 0) return -1;
            if (memo[remain] != -2) return memo[remain];
            int best = INT_MAX;
            for (int coin : coins) {
                int sub = dfs(remain - coin);
                if (sub >= 0) best = min(best, sub + 1);
            }
            return memo[remain] = best == INT_MAX ? -1 : best;
        };
        return dfs(amount);
    }
};
