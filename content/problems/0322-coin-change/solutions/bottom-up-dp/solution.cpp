class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        int unreachable = amount + 1;
        vector<int> dp(amount + 1, unreachable);
        dp[0] = 0;
        for (int value = 1; value <= amount; ++value)
            for (int coin : coins)
                if (coin <= value) dp[value] = min(dp[value], dp[value - coin] + 1);
        return dp[amount] == unreachable ? -1 : dp[amount];
    }
};
