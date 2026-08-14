const solution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-002',
  problems: [
    {
      id: 54, slug: 'spiral-matrix', title: '螺旋矩阵',
      studyTags: ['边界模拟', '分层遍历', '矩阵'],
      summary: '按从左到右、从上到下、从右到左、从下到上的顺序，螺旋返回矩阵中的所有元素。',
      insight: '维护尚未访问矩形的四条边，每完成一条边就向内收缩，并在逆向遍历前确认边界仍有效。',
      pitfalls: ['单行或单列时不能重复访问', '下边和左边遍历前要再次检查边界', '结果长度应恰好等于元素总数'],
      solutions: [solution('shrinking-boundaries', '四边界收缩', '最优', '循环遍历当前矩形的四条边并逐层向内。', ['遍历上边并增加 top', '遍历右边并减少 right', '边界有效时遍历下边和左边'], 'O(mn)', 'O(1)',
        `class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) answer.add(matrix[top][column]);
            top++;
            for (int row = top; row <= bottom; row++) answer.add(matrix[row][right]);
            right--;
            if (top <= bottom) { for (int column = right; column >= left; column--) answer.add(matrix[bottom][column]); bottom--; }
            if (left <= right) { for (int row = bottom; row >= top; row--) answer.add(matrix[row][left]); left++; }
        }
        return answer;
    }
}`,
        `class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val answer = ArrayList<Int>()
        var top = 0; var bottom = matrix.lastIndex; var left = 0; var right = matrix[0].lastIndex
        while (top <= bottom && left <= right) {
            for (column in left..right) answer.add(matrix[top][column]); top++
            for (row in top..bottom) answer.add(matrix[row][right]); right--
            if (top <= bottom) { for (column in right downTo left) answer.add(matrix[bottom][column]); bottom-- }
            if (left <= right) { for (row in bottom downTo top) answer.add(matrix[row][left]); left++ }
        }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> answer;
        int top = 0, bottom = matrix.size() - 1, left = 0, right = matrix[0].size() - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; ++column) answer.push_back(matrix[top][column]);
            ++top;
            for (int row = top; row <= bottom; ++row) answer.push_back(matrix[row][right]);
            --right;
            if (top <= bottom) { for (int column = right; column >= left; --column) answer.push_back(matrix[bottom][column]); --bottom; }
            if (left <= right) { for (int row = bottom; row >= top; --row) answer.push_back(matrix[row][left]); ++left; }
        }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'spiralOrder', parameterTypes: ['intMatrix'], returnType: 'intList', cases: [
        { name: '三阶方阵', args: [[[1, 2, 3], [4, 5, 6], [7, 8, 9]]], expected: [1, 2, 3, 6, 9, 8, 7, 4, 5] },
        { name: '两行矩阵', args: [[[1, 2, 3, 4], [5, 6, 7, 8]]], expected: [1, 2, 3, 4, 8, 7, 6, 5] },
        { name: '单列矩阵', args: [[[1], [2], [3]]], expected: [1, 2, 3] },
      ] },
    },
    {
      id: 64, slug: 'minimum-path-sum', title: '最小路径和',
      studyTags: ['网格动态规划', '状态压缩', '最优子结构'],
      summary: '从非负整数网格左上角出发，每次向右或向下，求到右下角路径上的最小数字总和。',
      insight: '到达当前格子的最小代价等于当前值加上方和左方代价中的较小者。',
      pitfalls: ['起点值必须计入总和', '第一行只能从左侧到达', '第一列只能从上方到达'],
      solutions: [solution('one-row-dp', '一维网格 DP', '最优', '用一行数组复用上方代价，并用刚更新的左侧值完成转移。', ['初始化第一行的前缀和', '逐行更新第一列', '其余位置加上上方和左方最小值'], 'O(mn)', 'O(n)',
        `class Solution {
    public int minPathSum(int[][] grid) {
        int[] cost = new int[grid[0].length];
        cost[0] = grid[0][0];
        for (int column = 1; column < cost.length; column++) cost[column] = cost[column - 1] + grid[0][column];
        for (int row = 1; row < grid.length; row++) {
            cost[0] += grid[row][0];
            for (int column = 1; column < cost.length; column++) cost[column] = Math.min(cost[column], cost[column - 1]) + grid[row][column];
        }
        return cost[cost.length - 1];
    }
}`,
        `class Solution {
    fun minPathSum(grid: Array<IntArray>): Int {
        val cost = IntArray(grid[0].size)
        cost[0] = grid[0][0]
        for (column in 1 until cost.size) cost[column] = cost[column - 1] + grid[0][column]
        for (row in 1 until grid.size) { cost[0] += grid[row][0]; for (column in 1 until cost.size) cost[column] = minOf(cost[column], cost[column - 1]) + grid[row][column] }
        return cost.last()
    }
}`,
        `class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        vector<int> cost(grid[0].size());
        cost[0] = grid[0][0];
        for (int column = 1; column < (int)cost.size(); ++column) cost[column] = cost[column - 1] + grid[0][column];
        for (int row = 1; row < (int)grid.size(); ++row) { cost[0] += grid[row][0]; for (int column = 1; column < (int)cost.size(); ++column) cost[column] = min(cost[column], cost[column - 1]) + grid[row][column]; }
        return cost.back();
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'minPathSum', parameterTypes: ['intMatrix'], returnType: 'int', cases: [
        { name: '绕开中间高代价', args: [[[1, 3, 1], [1, 5, 1], [4, 2, 1]]], expected: 7 },
        { name: '两行三列', args: [[[1, 2, 3], [4, 5, 6]]], expected: 12 },
        { name: '单格网格', args: [[[8]]], expected: 8 },
      ] },
    },
    {
      id: 69, slug: 'sqrtx', title: 'x 的平方根',
      studyTags: ['二分答案', '整数溢出', '向下取整'],
      summary: '计算非负整数 x 的算术平方根并向下取整，不使用内置幂函数。',
      insight: '答案满足平方不超过 x，可以在整数区间内二分查找最后一个满足条件的数。',
      pitfalls: ['乘法需要使用长整型避免溢出', '答案要求向下取整', '零和一可以由通用逻辑处理'],
      solutions: [solution('binary-answer', '二分最后可行值', '最优', '在 [0,x] 内查找平方不大于 x 的最大整数。', ['维护当前可行答案', 'middle² 不超过 x 时记录并向右找', '否则向左收缩'], 'O(log x)', 'O(1)',
        `class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, answer = 0;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long) middle * middle <= x) { answer = middle; left = middle + 1; } else right = middle - 1;
        }
        return answer;
    }
}`,
        `class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0; var right = x; var answer = 0
        while (left <= right) { val middle = left + (right - left) / 2; if (middle.toLong() * middle <= x) { answer = middle; left = middle + 1 } else right = middle - 1 }
        return answer
    }
}`,
        `class Solution {
public:
    int mySqrt(int x) {
        int left = 0, right = x, answer = 0;
        while (left <= right) { int middle = left + (right - left) / 2; if ((long long)middle * middle <= x) { answer = middle; left = middle + 1; } else right = middle - 1; }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'mySqrt', parameterTypes: ['int'], returnType: 'int', cases: [
        { name: '完全平方数', args: [4], expected: 2 },
        { name: '非完全平方数向下取整', args: [8], expected: 2 },
        { name: '最大整数避免溢出', args: [2147395599], expected: 46339 },
      ] },
    },
    {
      id: 72, slug: 'edit-distance', title: '编辑距离',
      studyTags: ['二维动态规划', '字符串转换', '前缀状态'],
      summary: '通过插入、删除或替换单个字符，把一个字符串转换成另一个字符串，求最少操作次数。',
      insight: '比较两个前缀末字符；相同时继承左上状态，不同时从插入、删除、替换三种前驱中取最小值再加一。',
      pitfalls: ['空字符串与另一前缀的距离等于前缀长度', '替换来自左上状态', '插入和删除来自同一行左侧与上一行同列'],
      solutions: [solution('prefix-dp', '前缀编辑动态规划', '最优', '二维表记录任意两个前缀之间的最短编辑距离。', ['初始化空前缀边界', '末字符相同则复制左上值', '否则取三个相邻状态最小值加一'], 'O(mn)', 'O(mn)',
        `class Solution {
    public int minDistance(String word1, String word2) {
        int[][] distance = new int[word1.length() + 1][word2.length() + 1];
        for (int first = 0; first <= word1.length(); first++) distance[first][0] = first;
        for (int second = 0; second <= word2.length(); second++) distance[0][second] = second;
        for (int first = 1; first <= word1.length(); first++) for (int second = 1; second <= word2.length(); second++) {
            if (word1.charAt(first - 1) == word2.charAt(second - 1)) distance[first][second] = distance[first - 1][second - 1];
            else distance[first][second] = 1 + Math.min(distance[first - 1][second - 1], Math.min(distance[first - 1][second], distance[first][second - 1]));
        }
        return distance[word1.length()][word2.length()];
    }
}`,
        `class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val distance = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (first in 0..word1.length) distance[first][0] = first
        for (second in 0..word2.length) distance[0][second] = second
        for (first in 1..word1.length) for (second in 1..word2.length) distance[first][second] = if (word1[first - 1] == word2[second - 1]) distance[first - 1][second - 1] else 1 + minOf(distance[first - 1][second - 1], distance[first - 1][second], distance[first][second - 1])
        return distance[word1.length][word2.length]
    }
}`,
        `class Solution {
public:
    int minDistance(string word1, string word2) {
        vector<vector<int>> distance(word1.size() + 1, vector<int>(word2.size() + 1));
        for (int first = 0; first <= (int)word1.size(); ++first) distance[first][0] = first;
        for (int second = 0; second <= (int)word2.size(); ++second) distance[0][second] = second;
        for (int first = 1; first <= (int)word1.size(); ++first) for (int second = 1; second <= (int)word2.size(); ++second) {
            if (word1[first - 1] == word2[second - 1]) distance[first][second] = distance[first - 1][second - 1];
            else distance[first][second] = 1 + min({distance[first - 1][second - 1], distance[first - 1][second], distance[first][second - 1]});
        }
        return distance[word1.size()][word2.size()];
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'minDistance', parameterTypes: ['string', 'string'], returnType: 'int', cases: [
        { name: '替换删除组合', args: ['horse', 'ros'], expected: 3 },
        { name: '多种编辑操作', args: ['intention', 'execution'], expected: 5 },
        { name: '从空串插入', args: ['', 'abc'], expected: 3 },
      ] },
    },
    {
      id: 73, slug: 'set-matrix-zeroes', title: '矩阵置零',
      studyTags: ['原地标记', '首行首列', '矩阵'],
      summary: '若矩阵中某元素为零，就把它所在的整行和整列都设为零，要求原地完成。',
      insight: '用矩阵第一行和第一列充当标记数组，再额外记录它们自身是否原本包含零。',
      pitfalls: ['首行首列需要独立布尔标记', '写标记时不能提前清零整行整列', '最后处理首行首列'],
      solutions: [solution('first-row-column-markers', '首行首列复用标记', '最优', '扫描内部零并在对应首行首列位置做标记，第二遍据此清零。', ['记录首行和首列是否含零', '扫描内部元素并写行列标记', '清零内部后按布尔标记处理首行首列'], 'O(mn)', 'O(1)',
        `class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColumnZero = false;
        for (int column = 0; column < matrix[0].length; column++) if (matrix[0][column] == 0) firstRowZero = true;
        for (int row = 0; row < matrix.length; row++) if (matrix[row][0] == 0) firstColumnZero = true;
        for (int row = 1; row < matrix.length; row++) for (int column = 1; column < matrix[0].length; column++) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0; }
        for (int row = 1; row < matrix.length; row++) for (int column = 1; column < matrix[0].length; column++) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
        if (firstRowZero) Arrays.fill(matrix[0], 0);
        if (firstColumnZero) for (int[] row : matrix) row[0] = 0;
    }
}`,
        `class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var firstRowZero = matrix[0].any { it == 0 }
        var firstColumnZero = matrix.any { it[0] == 0 }
        for (row in 1 until matrix.size) for (column in 1 until matrix[0].size) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0 }
        for (row in 1 until matrix.size) for (column in 1 until matrix[0].size) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0
        if (firstRowZero) matrix[0].fill(0)
        if (firstColumnZero) for (row in matrix) row[0] = 0
    }
}`,
        `class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        bool firstRowZero = false, firstColumnZero = false;
        for (int value : matrix[0]) if (value == 0) firstRowZero = true;
        for (const auto& row : matrix) if (row[0] == 0) firstColumnZero = true;
        for (int row = 1; row < (int)matrix.size(); ++row) for (int column = 1; column < (int)matrix[0].size(); ++column) if (matrix[row][column] == 0) { matrix[row][0] = 0; matrix[0][column] = 0; }
        for (int row = 1; row < (int)matrix.size(); ++row) for (int column = 1; column < (int)matrix[0].size(); ++column) if (matrix[row][0] == 0 || matrix[0][column] == 0) matrix[row][column] = 0;
        if (firstRowZero) fill(matrix[0].begin(), matrix[0].end(), 0);
        if (firstColumnZero) for (auto& row : matrix) row[0] = 0;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'setZeroes', parameterTypes: ['intMatrix'], returnType: 'void', cases: [
        { name: '内部零清除一行一列', args: [[[1, 1, 1], [1, 0, 1], [1, 1, 1]]], expectedArgs: [{ index: 0, type: 'intMatrix', expected: [[1, 0, 1], [0, 0, 0], [1, 0, 1]] }] },
        { name: '首行与内部都含零', args: [[[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]], expectedArgs: [{ index: 0, type: 'intMatrix', expected: [[0, 0, 0, 0], [0, 4, 5, 0], [0, 3, 1, 0]] }] },
        { name: '单元素非零矩阵', args: [[[1]]], expectedArgs: [{ index: 0, type: 'intMatrix', expected: [[1]] }] },
      ] },
    },
  ],
}
