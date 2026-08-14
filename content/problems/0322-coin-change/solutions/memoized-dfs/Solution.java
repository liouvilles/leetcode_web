class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        memo[0] = 0;
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int remain, int[] memo) {
        if (remain < 0) return -1;
        if (memo[remain] != -2) return memo[remain];
        int best = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = dfs(coins, remain - coin, memo);
            if (sub >= 0) best = Math.min(best, sub + 1);
        }
        return memo[remain] = best == Integer.MAX_VALUE ? -1 : best;
    }
}
