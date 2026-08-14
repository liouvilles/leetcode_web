import original from './batch-003-i.mjs'

const cooldown = {
  id: 309,
  slug: 'best-time-to-buy-and-sell-stock-with-cooldown',
  title: '买卖股票的最佳时机含冷冻期',
  studyTags: ['状态机 DP', '冷冻期', '股票交易'],
  summary: '可以多次买卖一只股票，但卖出后的下一天不能买入；任意时刻最多持有一股，求最大利润。',
  insight: '每天只需维护持有、当天卖出、空仓休息三种状态；买入只能从前一天休息状态转移。',
  pitfalls: ['卖出后隔一天才能再次买入', '同一天不能同时完成多次交易', '最终答案不能取仍持有股票的状态'],
  solutions: [
    {
      id: 'state-machine-dp',
      title: '三状态滚动 DP',
      kind: '最优',
      idea: '按持有、卖出、休息三种状态滚动更新，状态定义直接编码冷冻约束。',
      steps: ['hold=max(oldHold,oldRest-price)', 'sold=oldHold+price', 'rest=max(oldRest,oldSold)，最终取 sold 与 rest 较大值'],
      complexity: { time: 'O(n)', space: 'O(1)' },
      code: {
        java: `class Solution {
    public int maxProfit(int[] prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int day = 1; day < prices.length; day++) {
            int oldHold = hold, oldSold = sold, oldRest = rest;
            hold = Math.max(oldHold, oldRest - prices[day]);
            sold = oldHold + prices[day];
            rest = Math.max(oldRest, oldSold);
        }
        return Math.max(sold, rest);
    }
}`,
        kotlin: `class Solution {
    fun maxProfit(prices: IntArray): Int {
        var hold = -prices[0]
        var sold = 0
        var rest = 0
        for (day in 1 until prices.size) {
            val oldHold = hold
            val oldSold = sold
            val oldRest = rest
            hold = maxOf(oldHold, oldRest - prices[day])
            sold = oldHold + prices[day]
            rest = maxOf(oldRest, oldSold)
        }
        return maxOf(sold, rest)
    }
}`,
        cpp: `class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold = -prices[0], sold = 0, rest = 0;
        for (int day = 1; day < (int)prices.size(); ++day) {
            int oldHold = hold, oldSold = sold, oldRest = rest;
            hold = max(oldHold, oldRest - prices[day]);
            sold = oldHold + prices[day];
            rest = max(oldRest, oldSold);
        }
        return max(sold, rest);
    }
};`,
      },
    },
  ],
  tests: {
    schemaVersion: 1,
    mode: 'function',
    method: 'maxProfit',
    parameterTypes: ['intArray'],
    returnType: 'int',
    cases: [
      { name: '卖出后经过冷冻期再买入', args: [[1, 2, 3, 0, 2]], expected: 3 },
      { name: '单日无法交易', args: [[1]], expected: 0 },
      { name: '先下降后一次交易', args: [[2, 1, 4]], expected: 3 },
    ],
  },
}

export default {
  ...original,
  problems: [...original.problems.filter((problem) => problem.id !== 226), cooldown],
}
