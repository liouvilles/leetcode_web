const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 118, slug: 'pascals-triangle', title: '杨辉三角', studyTags: ['动态规划', '二维列表', '递推'],
    summary: '生成杨辉三角的前 numRows 行，每行首尾为一，其余元素等于上一行相邻两数之和。',
    insight: '第 row 行有 row+1 个元素，边界直接填一，内部位置从上一行的 column-1 与 column 转移。',
    pitfalls: ['行下标从零开始时长度为 row+1', '首尾元素没有两个父元素', '答案逐行依赖上一行'],
    solutions: [s('row-by-row-dp', '逐行递推', '按定义从上一行构造下一行，并立即加入结果。', ['为当前行创建 row+1 个位置', '边界填一', '内部填 previous[column-1]+previous[column]'], 'O(numRows²)', 'O(numRows²)',
      `class Solution {
    public List<List<Integer>> generate(int numRows) { List<List<Integer>> answer = new ArrayList<>(); for (int row = 0; row < numRows; row++) { List<Integer> current = new ArrayList<>(); for (int column = 0; column <= row; column++) current.add(column == 0 || column == row ? 1 : answer.get(row - 1).get(column - 1) + answer.get(row - 1).get(column)); answer.add(current); } return answer; }
}`,
      `class Solution {
    fun generate(numRows: Int): List<List<Int>> { val answer = mutableListOf<List<Int>>(); for (row in 0 until numRows) { val current = MutableList(row + 1) { 1 }; for (column in 1 until row) current[column] = answer[row - 1][column - 1] + answer[row - 1][column]; answer.add(current) }; return answer }
}`,
      `class Solution {
public:
    vector<vector<int>> generate(int numRows) { vector<vector<int>> answer; for (int row = 0; row < numRows; ++row) { vector<int> current(row + 1, 1); for (int column = 1; column < row; ++column) current[column] = answer[row - 1][column - 1] + answer[row - 1][column]; answer.push_back(current); } return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'generate', parameterTypes: ['int'], returnType: 'intListMatrix', cases: [
      { name: '生成五行', args: [5], expected: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]] }, { name: '只有第一行', args: [1], expected: [[1]] }, { name: '生成两行', args: [2], expected: [[1],[1,1]] },
    ] },
  },
  {
    id: 120, slug: 'triangle', title: '三角形最小路径和', studyTags: ['动态规划', '自底向上', '滚动数组'],
    summary: '从三角形顶点走到最后一行，每步只能走到下一行同列或后一列，求路径元素的最小总和。',
    insight: '从底向上计算时，位置 (row,column) 的最优后缀只依赖下一行 dp[column] 与 dp[column+1]。',
    pitfalls: ['相邻位置仅有正下方和右下方', '元素可能为负', '一维数组应从底部向上覆盖'],
    solutions: [s('bottom-up-dp', '自底向上一维动态规划', '把下一行的最小后缀合并到当前行，最终 dp[0] 即答案。', ['dp 初始化为零或末行', '从最后一行向顶行遍历', 'dp[column]=value+min(dp[column],dp[column+1])'], 'O(n²)', 'O(n)',
      `class Solution {
    public int minimumTotal(List<List<Integer>> triangle) { int[] dp = new int[triangle.size() + 1]; for (int row = triangle.size() - 1; row >= 0; row--) for (int column = 0; column <= row; column++) dp[column] = triangle.get(row).get(column) + Math.min(dp[column], dp[column + 1]); return dp[0]; }
}`,
      `class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int { val dp = IntArray(triangle.size + 1); for (row in triangle.lastIndex downTo 0) for (column in 0..row) dp[column] = triangle[row][column] + minOf(dp[column], dp[column + 1]); return dp[0] }
}`,
      `class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) { vector<int> dp(triangle.size() + 1); for (int row = triangle.size() - 1; row >= 0; --row) for (int column = 0; column <= row; ++column) dp[column] = triangle[row][column] + min(dp[column], dp[column + 1]); return dp[0]; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'minimumTotal', parameterTypes: ['intListMatrix'], returnType: 'int', cases: [
      { name: '四层三角形', args: [[[2],[3,4],[6,5,7],[4,1,8,3]]], expected: 11 }, { name: '单个负数', args: [[[-10]]], expected: -10 }, { name: '包含负数路径', args: [[[-1],[2,3],[1,-1,-3]]], expected: -1 },
    ] },
  },
  {
    id: 122, slug: 'best-time-to-buy-and-sell-stock-ii', title: '买卖股票的最佳时机 II', studyTags: ['贪心', '股票', '正差分'],
    summary: '每天最多持有一股且可以买卖多次，计算价格序列中能获得的最大总利润。',
    insight: '任意上涨区间的首尾利润等于其中所有相邻正差之和，因此累加每次上涨即可实现最优。',
    pitfalls: ['同一天可以卖出后再买入', '下降差值不能计入利润', '无需显式寻找完整波谷和波峰'],
    solutions: [s('sum-positive-differences', '累加相邻正收益', '把每段上涨拆成若干天的一步交易，利润总和不变。', ['从第二天开始扫描', '若 price[i]>price[i-1] 则累加差值', '返回累计利润'], 'O(n)', 'O(1)',
      `class Solution {
    public int maxProfit(int[] prices) { int profit = 0; for (int day = 1; day < prices.length; day++) profit += Math.max(0, prices[day] - prices[day - 1]); return profit; }
}`,
      `class Solution {
    fun maxProfit(prices: IntArray): Int { var profit = 0; for (day in 1 until prices.size) profit += maxOf(0, prices[day] - prices[day - 1]); return profit }
}`,
      `class Solution {
public:
    int maxProfit(vector<int>& prices) { int profit = 0; for (int day = 1; day < (int)prices.size(); ++day) profit += max(0, prices[day] - prices[day - 1]); return profit; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'maxProfit', parameterTypes: ['intArray'], returnType: 'int', cases: [
      { name: '两段上涨', args: [[7,1,5,3,6,4]], expected: 7 }, { name: '持续上涨', args: [[1,2,3,4,5]], expected: 4 }, { name: '持续下跌', args: [[7,6,4,3,1]], expected: 0 },
    ] },
  },
  {
    id: 123, slug: 'best-time-to-buy-and-sell-stock-iii', title: '买卖股票的最佳时机 III', studyTags: ['动态规划', '状态机', '股票'],
    summary: '在最多完成两笔买卖且任意时刻最多持有一股的条件下，计算可获得的最大利润。',
    insight: '依次维护第一次买入、第一次卖出、第二次买入、第二次卖出的最佳余额，每个价格更新四个状态。',
    pitfalls: ['买入状态保存的是扣款后的最大余额', '第二次买入依赖第一次卖出的利润', '不足两笔交易也包含在状态中'],
    solutions: [s('four-state-dp', '四状态滚动更新', '把两笔交易拆成四个有顺序的动作，用常量空间保存各动作后的最优值。', ['buy1=max(buy1,-price)', 'sell1 与 buy2 依次更新', 'sell2 更新为最终答案'], 'O(n)', 'O(1)',
      `class Solution {
    public int maxProfit(int[] prices) { int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0; for (int price : prices) { buy1 = Math.max(buy1, -price); sell1 = Math.max(sell1, buy1 + price); buy2 = Math.max(buy2, sell1 - price); sell2 = Math.max(sell2, buy2 + price); } return sell2; }
}`,
      `class Solution {
    fun maxProfit(prices: IntArray): Int { var buy1 = Int.MIN_VALUE; var sell1 = 0; var buy2 = Int.MIN_VALUE; var sell2 = 0; for (price in prices) { buy1 = maxOf(buy1, -price); sell1 = maxOf(sell1, buy1 + price); buy2 = maxOf(buy2, sell1 - price); sell2 = maxOf(sell2, buy2 + price) }; return sell2 }
}`,
      `class Solution {
public:
    int maxProfit(vector<int>& prices) { int buy1 = INT_MIN, sell1 = 0, buy2 = INT_MIN, sell2 = 0; for (int price : prices) { buy1 = max(buy1, -price); sell1 = max(sell1, buy1 + price); buy2 = max(buy2, sell1 - price); sell2 = max(sell2, buy2 + price); } return sell2; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'maxProfit', parameterTypes: ['intArray'], returnType: 'int', cases: [
      { name: '两笔交易最优', args: [[3,3,5,0,0,3,1,4]], expected: 6 }, { name: '一段持续上涨', args: [[1,2,3,4,5]], expected: 4 }, { name: '无盈利机会', args: [[7,6,4,3,1]], expected: 0 },
    ] },
  },
  {
    id: 129, slug: 'sum-root-to-leaf-numbers', title: '求根节点到叶节点数字之和', studyTags: ['二叉树', '深度优先搜索', '路径累积'],
    summary: '树中每个节点保存一位数字，把每条根到叶路径视为一个十进制数，返回这些数的总和。',
    insight: '沿路径进入新节点时令当前值乘十再加节点数字；到叶子时把完整数字计入总和。',
    pitfalls: ['只有叶子才结束一个数字', '路径上的前导零自然有效', '空树贡献零'],
    solutions: [s('dfs-number-building', '深度优先构造路径数字', '递归参数携带父路径数值，每深入一层追加一位。', ['空节点返回零', 'current=prefix*10+node.val', '叶子返回 current，否则返回左右子树和'], 'O(n)', 'O(h)',
      `class Solution {
    public int sumNumbers(TreeNode root) { return dfs(root, 0); }
    private int dfs(TreeNode node, int prefix) { if (node == null) return 0; int current = prefix * 10 + node.val; if (node.left == null && node.right == null) return current; return dfs(node.left, current) + dfs(node.right, current); }
}`,
      `class Solution {
    fun sumNumbers(root: TreeNode?): Int { fun dfs(node: TreeNode?, prefix: Int): Int { if (node == null) return 0; val current = prefix * 10 + node.\`val\`; if (node.left == null && node.right == null) return current; return dfs(node.left, current) + dfs(node.right, current) }; return dfs(root, 0) }
}`,
      `class Solution {
    int dfs(TreeNode* node, int prefix) { if (!node) return 0; int current = prefix * 10 + node->val; if (!node->left && !node->right) return current; return dfs(node->left, current) + dfs(node->right, current); }
public:
    int sumNumbers(TreeNode* root) { return dfs(root, 0); }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'sumNumbers', parameterTypes: ['treeNode'], returnType: 'int', cases: [
      { name: '两条两位数路径', args: [[1,2,3]], expected: 25 }, { name: '三条路径', args: [[4,9,0,5,1]], expected: 1026 }, { name: '空树', args: [[]], expected: 0 },
    ] },
  },
] }
