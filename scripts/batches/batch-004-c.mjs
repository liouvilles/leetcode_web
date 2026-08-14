const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 57, slug: 'insert-interval', title: '插入区间', studyTags: ['区间合并', '线性扫描', '分类讨论'],
    summary: '把一个新区间插入按起点有序且互不重叠的区间列表，并合并所有重叠部分。',
    insight: '区间只分为新区间左侧、与新区间重叠、以及新区间右侧三段，按顺序一次扫描即可。',
    pitfalls: ['端点相接也应视为重叠', '新区间可能覆盖多个原区间', '输入为空时只返回新区间'],
    solutions: [s('three-phase-scan', '三阶段线性合并', '先收集完全位于左侧的区间，再扩张新区间，最后追加右侧区间。', ['追加 end < newStart 的区间', '对 start <= newEnd 的区间更新合并边界', '加入合并区间和剩余区间'], 'O(n)', 'O(n)',
      `class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>(); int index = 0;
        while (index < intervals.length && intervals[index][1] < newInterval[0]) answer.add(intervals[index++]);
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) { newInterval[0] = Math.min(newInterval[0], intervals[index][0]); newInterval[1] = Math.max(newInterval[1], intervals[index++][1]); }
        answer.add(newInterval); while (index < intervals.length) answer.add(intervals[index++]);
        return answer.toArray(new int[answer.size()][]);
    }
}`,
      `class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val answer = mutableListOf<IntArray>(); var index = 0
        while (index < intervals.size && intervals[index][1] < newInterval[0]) answer.add(intervals[index++])
        while (index < intervals.size && intervals[index][0] <= newInterval[1]) { newInterval[0] = minOf(newInterval[0], intervals[index][0]); newInterval[1] = maxOf(newInterval[1], intervals[index++][1]) }
        answer.add(newInterval); while (index < intervals.size) answer.add(intervals[index++])
        return answer.toTypedArray()
    }
}`,
      `class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<vector<int>> answer; int index = 0;
        while (index < (int)intervals.size() && intervals[index][1] < newInterval[0]) answer.push_back(intervals[index++]);
        while (index < (int)intervals.size() && intervals[index][0] <= newInterval[1]) { newInterval[0] = min(newInterval[0], intervals[index][0]); newInterval[1] = max(newInterval[1], intervals[index++][1]); }
        answer.push_back(newInterval); while (index < (int)intervals.size()) answer.push_back(intervals[index++]); return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'insert', parameterTypes: ['intMatrix','intArray'], returnType: 'intMatrix', cases: [
      { name: '合并一个区间', args: [[[1,3],[6,9]],[2,5]], expected: [[1,5],[6,9]] },
      { name: '跨越多个区间', args: [[[1,2],[3,5],[6,7],[8,10],[12,16]],[4,8]], expected: [[1,2],[3,10],[12,16]] },
      { name: '插入空列表', args: [[],[5,7]], expected: [[5,7]] },
    ] },
  },
  {
    id: 59, slug: 'spiral-matrix-ii', title: '螺旋矩阵 II', studyTags: ['矩阵模拟', '边界收缩', '螺旋遍历'],
    summary: '生成一个 n×n 矩阵，把 1 到 n² 按顺时针螺旋顺序填入。',
    insight: '维护上下左右四条未填边界，每完成一条边就向内收缩，并在交错前检查边界。',
    pitfalls: ['下边和左边需要避免重复填写', '每轮最多收缩四条边', '单行或单列中心仍要正确处理'],
    solutions: [s('shrinking-boundaries', '四边界螺旋填充', '按上、右、下、左顺序填充当前外圈并逐层内缩。', ['维护 top/bottom/left/right', '依次填四条边并收缩', '边界相交后停止'], 'O(n²)', 'O(1) excluding output',
      `class Solution {
    public int[][] generateMatrix(int n) {
        int[][] answer = new int[n][n]; int top = 0, bottom = n - 1, left = 0, right = n - 1, value = 1;
        while (top <= bottom && left <= right) { for (int column = left; column <= right; column++) answer[top][column] = value++; top++; for (int row = top; row <= bottom; row++) answer[row][right] = value++; right--; if (top <= bottom) { for (int column = right; column >= left; column--) answer[bottom][column] = value++; bottom--; } if (left <= right) { for (int row = bottom; row >= top; row--) answer[row][left] = value++; left++; } }
        return answer;
    }
}`,
      `class Solution {
    fun generateMatrix(n: Int): Array<IntArray> {
        val answer = Array(n) { IntArray(n) }; var top = 0; var bottom = n - 1; var left = 0; var right = n - 1; var value = 1
        while (top <= bottom && left <= right) { for (column in left..right) answer[top][column] = value++; top++; for (row in top..bottom) answer[row][right] = value++; right--; if (top <= bottom) { for (column in right downTo left) answer[bottom][column] = value++; bottom-- }; if (left <= right) { for (row in bottom downTo top) answer[row][left] = value++; left++ } }
        return answer
    }
}`,
      `class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> answer(n, vector<int>(n)); int top = 0, bottom = n - 1, left = 0, right = n - 1, value = 1;
        while (top <= bottom && left <= right) { for (int column = left; column <= right; ++column) answer[top][column] = value++; ++top; for (int row = top; row <= bottom; ++row) answer[row][right] = value++; --right; if (top <= bottom) { for (int column = right; column >= left; --column) answer[bottom][column] = value++; --bottom; } if (left <= right) { for (int row = bottom; row >= top; --row) answer[row][left] = value++; ++left; } } return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'generateMatrix', parameterTypes: ['int'], returnType: 'intMatrix', cases: [
      { name: '三阶矩阵', args: [3], expected: [[1,2,3],[8,9,4],[7,6,5]] }, { name: '单元素', args: [1], expected: [[1]] }, { name: '二阶矩阵', args: [2], expected: [[1,2],[4,3]] },
    ] },
  },
  {
    id: 61, slug: 'rotate-list', title: '旋转链表', studyTags: ['链表成环', '长度取模', '断环'],
    summary: '把单链表向右旋转 k 次，使末尾 k 个节点移动到链表开头。',
    insight: '先首尾相连形成环；旋转后新尾位于原头之后 n-k%n-1 步，断开其后继即可。',
    pitfalls: ['空链表直接返回', 'k 可能远大于链表长度', '断环前要保存新头节点'],
    solutions: [s('circular-list', '成环后定位断点', '计算长度并连成环，通过取模后的步数找到新尾。', ['遍历得到长度和原尾', '原尾连接原头', '走 n-k%n-1 步到新尾并断环'], 'O(n)', 'O(1)',
      `class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int length = 1; ListNode tail = head; while (tail.next != null) { tail = tail.next; length++; }
        tail.next = head; int steps = length - k % length - 1; ListNode newTail = head; while (steps-- > 0) newTail = newTail.next;
        ListNode answer = newTail.next; newTail.next = null; return answer;
    }
}`,
      `class Solution {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 0) return head
        var length = 1; var tail = head; while (tail!!.next != null) { tail = tail.next; length++ }
        tail!!.next = head; var steps = length - k % length - 1; var newTail = head; while (steps-- > 0) newTail = newTail!!.next
        val answer = newTail!!.next; newTail.next = null; return answer
    }
}`,
      `class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if (!head || !head->next || k == 0) return head;
        int length = 1; ListNode* tail = head; while (tail->next) { tail = tail->next; ++length; }
        tail->next = head; int steps = length - k % length - 1; ListNode* newTail = head; while (steps-- > 0) newTail = newTail->next;
        ListNode* answer = newTail->next; newTail->next = nullptr; return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'rotateRight', parameterTypes: ['listNode','int'], returnType: 'listNode', cases: [
      { name: '向右旋转两位', args: [[1,2,3,4,5],2], expected: [4,5,1,2,3] }, { name: '步数超过长度', args: [[0,1,2],4], expected: [2,0,1] }, { name: '空链表', args: [[],3], expected: [] },
    ] },
  },
  {
    id: 63, slug: 'unique-paths-ii', title: '不同路径 II', studyTags: ['动态规划', '网格路径', '滚动数组'],
    summary: '在含障碍物的网格中，只能向右或向下移动，计算从左上角到右下角的不同路径数量。',
    insight: '一维数组 dp[column] 在更新前表示来自上方的路径数，更新后的 dp[column-1] 表示来自左侧；障碍处清零。',
    pitfalls: ['起点或终点可能是障碍', '遇到障碍必须把已有 dp 值清零', '第一行和第一列无需单独分支'],
    solutions: [s('one-dimensional-dp', '一维滚动动态规划', '逐行更新到达每个格子的路径数，障碍格不可继承路径。', ['dp[0] 按起点是否可用初始化', '障碍格令 dp[column]=0', '普通格累加左侧 dp[column-1]'], 'O(mn)', 'O(n)',
      `class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length]; dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] row : obstacleGrid) for (int column = 0; column < row.length; column++) { if (row[column] == 1) dp[column] = 0; else if (column > 0) dp[column] += dp[column - 1]; }
        return dp[dp.length - 1];
    }
}`,
      `class Solution {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        val dp = IntArray(obstacleGrid[0].size); dp[0] = if (obstacleGrid[0][0] == 0) 1 else 0
        for (row in obstacleGrid) for (column in row.indices) { if (row[column] == 1) dp[column] = 0 else if (column > 0) dp[column] += dp[column - 1] }
        return dp.last()
    }
}`,
      `class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<int> dp(obstacleGrid[0].size()); dp[0] = obstacleGrid[0][0] == 0;
        for (const auto& row : obstacleGrid) for (int column = 0; column < (int)row.size(); ++column) { if (row[column] == 1) dp[column] = 0; else if (column > 0) dp[column] += dp[column - 1]; }
        return dp.back();
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'uniquePathsWithObstacles', parameterTypes: ['intMatrix'], returnType: 'int', cases: [
      { name: '中心障碍', args: [[[0,0,0],[0,1,0],[0,0,0]]], expected: 2 }, { name: '首行障碍', args: [[[0,1],[0,0]]], expected: 1 }, { name: '起点被阻塞', args: [[[1]]], expected: 0 },
    ] },
  },
  {
    id: 66, slug: 'plus-one', title: '加一', studyTags: ['数组模拟', '进位', '从后向前'],
    summary: '用十进制数字数组表示一个非负整数，返回该整数加一后的数字数组。',
    insight: '从最低位开始处理进位；遇到小于九的数字时加一即可结束，全部为九才扩容。',
    pitfalls: ['不能把整个数字转换为内置整数', '连续的九都会变为零', '最高位进位需要新建更长数组'],
    solutions: [s('carry-from-end', '逆序处理进位', '从末位寻找首个可直接加一的位置，经过的九置零。', ['从末位向前扫描', '若当前位小于九则加一并返回', '否则置零；全部处理完返回首位为一的新数组'], 'O(n)', 'O(1) excluding output',
      `class Solution {
    public int[] plusOne(int[] digits) {
        for (int index = digits.length - 1; index >= 0; index--) { if (digits[index] < 9) { digits[index]++; return digits; } digits[index] = 0; }
        int[] answer = new int[digits.length + 1]; answer[0] = 1; return answer;
    }
}`,
      `class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (index in digits.lastIndex downTo 0) { if (digits[index] < 9) { digits[index]++; return digits }; digits[index] = 0 }
        return IntArray(digits.size + 1).also { it[0] = 1 }
    }
}`,
      `class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        for (int index = digits.size() - 1; index >= 0; --index) { if (digits[index] < 9) { ++digits[index]; return digits; } digits[index] = 0; }
        vector<int> answer(digits.size() + 1); answer[0] = 1; return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'plusOne', parameterTypes: ['intArray'], returnType: 'intArray', cases: [
      { name: '末位直接加一', args: [[1,2,3]], expected: [1,2,4] }, { name: '连续进位并扩容', args: [[9,9]], expected: [1,0,0] }, { name: '零加一', args: [[0]], expected: [1] },
    ] },
  },
] }
