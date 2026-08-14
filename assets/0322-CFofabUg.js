const l=322,n="coin-change",e="Coin Change",d="中等",t="动态规划",i=["数组","动态规划","广度优先搜索","背包问题","完全背包"],f=!1,o="https://leetcode.cn/problems/coin-change/",u="零钱兑换",a=["完全背包","最少步数","记忆化搜索"],s="给定可无限使用的硬币面额，求组成目标金额所需的最少硬币数；无法组成时返回 -1。",r="金额 x 的最优答案来自某个可用硬币 coin 加上金额 x-coin 的最优答案。",m=["硬币可以重复使用","不可达状态不能参与最小值更新","目标金额为 0 时答案是 0"],c=[{id:"bottom-up-dp",title:"自底向上动态规划",kind:"最优",idea:"dp[x] 表示凑成金额 x 的最少硬币数，从小金额逐步推到 amount。",steps:["用 amount + 1 初始化不可达状态，dp[0] = 0","枚举每个金额和可用硬币","从已可达的较小金额转移并返回 dp[amount]"],complexity:{time:"O(amount · k)",space:"O(amount)"},code:{java:`class Solution {
    public int coinChange(int[] coins, int amount) {
        int unreachable = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, unreachable);
        dp[0] = 0;
        for (int value = 1; value <= amount; value++) {
            for (int coin : coins) {
                if (coin <= value) dp[value] = Math.min(dp[value], dp[value - coin] + 1);
            }
        }
        return dp[amount] == unreachable ? -1 : dp[amount];
    }
}
`,kotlin:`class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val unreachable = amount + 1
        val dp = IntArray(amount + 1) { unreachable }
        dp[0] = 0
        for (value in 1..amount) for (coin in coins) {
            if (coin <= value) dp[value] = minOf(dp[value], dp[value - coin] + 1)
        }
        return if (dp[amount] == unreachable) -1 else dp[amount]
    }
}
`,cpp:`class Solution {
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
`}},{id:"memoized-dfs",title:"记忆化搜索",kind:"进阶",idea:"从目标金额向下尝试每种硬币，并缓存每个剩余金额的最优结果。",steps:["剩余金额为 0 时成功、为负时失败","读取或计算 memo[remain]","汇总所有有效子问题的最小值"],complexity:{time:"O(amount · k)",space:"O(amount)"},code:{java:`class Solution {
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
`,kotlin:`class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memo = IntArray(amount + 1) { -2 }
        memo[0] = 0
        fun dfs(remain: Int): Int {
            if (remain < 0) return -1
            if (memo[remain] != -2) return memo[remain]
            var best = Int.MAX_VALUE
            for (coin in coins) {
                val sub = dfs(remain - coin)
                if (sub >= 0) best = minOf(best, sub + 1)
            }
            memo[remain] = if (best == Int.MAX_VALUE) -1 else best
            return memo[remain]
        }
        return dfs(amount)
    }
}
`,cpp:`class Solution {
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
`}},{id:"bfs-amounts",title:"金额状态 BFS",kind:"进阶",idea:"把金额视作图上的状态，每加一枚硬币走一条边；首次到达 amount 的层数就是最少硬币数。",steps:["从金额 0 入队并标记","逐层尝试加上每种硬币","首次生成 amount 时返回当前层数加一"],complexity:{time:"O(amount · k)",space:"O(amount)"},code:{java:`class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        boolean[] visited = new boolean[amount + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0); visited[0] = true;
        int used = 0;
        while (!queue.isEmpty()) {
            used++;
            for (int size = queue.size(); size > 0; size--) {
                int current = queue.poll();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) return used;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return -1;
    }
}
`,kotlin:`class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val visited = BooleanArray(amount + 1)
        val queue = java.util.ArrayDeque<Int>()
        queue.offer(0)
        visited[0] = true
        var used = 0
        while (queue.isNotEmpty()) {
            used++
            repeat(queue.size) {
                val current = queue.poll()
                for (coin in coins) {
                    val next = current + coin
                    if (next == amount) return used
                    if (next < amount && !visited[next]) {
                        visited[next] = true
                        queue.offer(next)
                    }
                }
            }
        }
        return -1
    }
}
`,cpp:`class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        if (amount == 0) return 0;
        vector<bool> visited(amount + 1);
        queue<int> values;
        values.push(0); visited[0] = true;
        int used = 0;
        while (!values.empty()) {
            ++used;
            for (int size = values.size(); size > 0; --size) {
                int current = values.front(); values.pop();
                for (int coin : coins) {
                    int next = current + coin;
                    if (next == amount) return used;
                    if (next < amount && !visited[next]) {
                        visited[next] = true;
                        values.push(next);
                    }
                }
            }
        }
        return -1;
    }
};
`}}],p={id:322,slug:n,titleEn:e,difficulty:"中等",category:t,officialTags:i,paidOnly:!1,sourceUrl:o,title:u,studyTags:a,summary:s,insight:r,pitfalls:m,solutions:c};export{t as category,p as default,d as difficulty,l as id,r as insight,i as officialTags,f as paidOnly,m as pitfalls,n as slug,c as solutions,o as sourceUrl,a as studyTags,s as summary,u as title,e as titleEn};
