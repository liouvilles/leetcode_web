const solution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-002',
  problems: [
    {
      id: 26, slug: 'remove-duplicates-from-sorted-array', title: '删除有序数组中的重复项',
      studyTags: ['快慢指针', '原地修改', '有序去重'],
      summary: '原地删除非严格递增数组中的重复值，使前 k 个位置保存所有不同元素并返回 k。',
      insight: '有序数组的相同值连续出现，慢指针只需指向下一个不同元素应写入的位置。',
      pitfalls: ['返回值是不同元素数量', '只要求前 k 个位置正确', '空数组需要返回 0'],
      solutions: [solution('two-pointers', '快慢指针覆盖', '最优', '快指针扫描新值，慢指针维护去重后前缀长度。', ['空数组直接返回零', '当前值不同于已写入前缀末尾时写到 slow', '返回 slow 作为有效长度'], 'O(n)', 'O(1)',
        `class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int length = 1;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[length - 1]) nums[length++] = nums[index];
        }
        return length;
    }
}`,
        `class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var length = 1
        for (index in 1 until nums.size) if (nums[index] != nums[length - 1]) nums[length++] = nums[index]
        return length
    }
}`,
        `class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) return 0;
        int length = 1;
        for (int index = 1; index < (int)nums.size(); ++index) if (nums[index] != nums[length - 1]) nums[length++] = nums[index];
        return length;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'removeDuplicates', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '一个重复值', args: [[1, 1, 2]], expected: 2, expectedArgs: [{ index: 0, type: 'intArray', expected: [1, 2, 2] }] },
        { name: '多组重复值', args: [[0, 0, 1, 1, 1, 2, 2, 3, 3, 4]], expected: 5, expectedArgs: [{ index: 0, type: 'intArray', expected: [0, 1, 2, 3, 4, 2, 2, 3, 3, 4] }] },
        { name: '空数组', args: [[]], expected: 0, expectedArgs: [{ index: 0, type: 'intArray', expected: [] }] },
      ] },
    },
    {
      id: 34, slug: 'find-first-and-last-position-of-element-in-sorted-array', title: '在排序数组中查找元素的第一个和最后一个位置',
      studyTags: ['二分边界', 'lower bound', '闭开区间'],
      summary: '在非递减数组中返回目标值第一次和最后一次出现的下标，不存在时返回 [-1,-1]。',
      insight: '分别查找第一个不小于 target 和第一个大于 target 的位置，就能得到目标区间。',
      pitfalls: ['第二个边界是 target + 1 的 lower bound 语义', '要先验证左边界确实命中目标', '空数组同样适用'],
      solutions: [solution('two-lower-bounds', '两次边界二分', '最优', '统一实现首个不小于给定值的位置，分别求左右边界。', ['求 lowerBound(target)', '检查是否越界或未命中', '求 lowerBound(target + 1) 并减一'], 'O(log n)', 'O(1)',
        `class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target);
        if (first == nums.length || nums[first] != target) return new int[] {-1, -1};
        return new int[] {first, lowerBound(nums, target + 1L) - 1};
    }
    private int lowerBound(int[] nums, long target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) left = middle + 1; else right = middle;
        }
        return left;
    }
}`,
        `class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val first = lowerBound(nums, target.toLong())
        if (first == nums.size || nums[first] != target) return intArrayOf(-1, -1)
        return intArrayOf(first, lowerBound(nums, target.toLong() + 1) - 1)
    }
    private fun lowerBound(nums: IntArray, target: Long): Int {
        var left = 0
        var right = nums.size
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle].toLong() < target) left = middle + 1 else right = middle }
        return left
    }
}`,
        `class Solution {
    int lowerBound(const vector<int>& nums, long long target) {
        int left = 0, right = nums.size();
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int first = lowerBound(nums, target);
        if (first == (int)nums.size() || nums[first] != target) return {-1, -1};
        return {first, lowerBound(nums, (long long)target + 1) - 1};
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'searchRange', parameterTypes: ['intArray', 'int'], returnType: 'intArray', cases: [
        { name: '目标连续出现', args: [[5, 7, 7, 8, 8, 10], 8], expected: [3, 4] },
        { name: '目标不存在', args: [[5, 7, 7, 8, 8, 10], 6], expected: [-1, -1] },
        { name: '单元素命中', args: [[1], 1], expected: [0, 0] },
      ] },
    },
    {
      id: 35, slug: 'search-insert-position', title: '搜索插入位置',
      studyTags: ['二分查找', '插入边界', 'lower bound'],
      summary: '在严格递增数组中查找目标值；若不存在，返回它按顺序插入后应处于的下标。',
      insight: '答案就是第一个大于或等于目标值的位置，也可能等于数组长度。',
      pitfalls: ['右边界设为数组长度才能表示尾部插入', '目标存在时仍返回其原下标', '循环维持左闭右开区间'],
      solutions: [solution('lower-bound', '左闭右开二分', '最优', '查找第一个不小于目标值的位置。', ['初始化 [0,n) 区间', '中间值小于目标时舍弃左半部分', '否则保留中点并收缩右边界'], 'O(log n)', 'O(1)',
        `class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
}`,
        `class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1 else right = middle }
        return left
    }
}`,
        `class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int left = 0, right = nums.size();
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] < target) left = middle + 1; else right = middle; }
        return left;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'searchInsert', parameterTypes: ['intArray', 'int'], returnType: 'int', cases: [
        { name: '目标已存在', args: [[1, 3, 5, 6], 5], expected: 2 },
        { name: '插入数组中部', args: [[1, 3, 5, 6], 2], expected: 1 },
        { name: '插入数组末尾', args: [[1, 3, 5, 6], 7], expected: 4 },
      ] },
    },
    {
      id: 45, slug: 'jump-game-ii', title: '跳跃游戏 II',
      studyTags: ['贪心分层', '最远覆盖', '最少步数'],
      summary: '数组元素表示从当前位置最多可跳的距离，计算从第一个位置到最后一个位置所需的最少跳跃次数。',
      insight: '当前一次跳跃能够覆盖的区间相当于 BFS 的一层；扫描到层末端时，再把边界扩展到本层可达的最远点。',
      pitfalls: ['无需真正选择每一步落点', '最后一个位置不需要继续扩展', '题目保证终点可达'],
      solutions: [solution('greedy-levels', '区间分层贪心', '最优', '扫描当前跳跃次数覆盖的所有位置，并收集下一次跳跃可到的最远边界。', ['维护 currentEnd 和 farthest', '扫描到 currentEnd 时完成一次跳跃', '把 currentEnd 更新为 farthest'], 'O(n)', 'O(1)',
        `class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            farthest = Math.max(farthest, index + nums[index]);
            if (index == currentEnd) { jumps++; currentEnd = farthest; }
        }
        return jumps;
    }
}`,
        `class Solution {
    fun jump(nums: IntArray): Int {
        var jumps = 0
        var currentEnd = 0
        var farthest = 0
        for (index in 0 until nums.lastIndex) { farthest = maxOf(farthest, index + nums[index]); if (index == currentEnd) { jumps++; currentEnd = farthest } }
        return jumps
    }
}`,
        `class Solution {
public:
    int jump(vector<int>& nums) {
        int jumps = 0, currentEnd = 0, farthest = 0;
        for (int index = 0; index + 1 < (int)nums.size(); ++index) { farthest = max(farthest, index + nums[index]); if (index == currentEnd) { ++jumps; currentEnd = farthest; } }
        return jumps;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'jump', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '两次跳到终点', args: [[2, 3, 1, 1, 4]], expected: 2 },
        { name: '中间存在零仍可越过', args: [[2, 3, 0, 1, 4]], expected: 2 },
        { name: '单元素无需跳跃', args: [[0]], expected: 0 },
      ] },
    },
    {
      id: 48, slug: 'rotate-image', title: '旋转图像',
      studyTags: ['矩阵原地变换', '转置', '行反转'],
      summary: '把 n×n 矩阵原地顺时针旋转九十度，不能另外创建同规模矩阵。',
      insight: '顺时针旋转等价于先沿主对角线转置，再把每一行左右反转。',
      pitfalls: ['矩阵必须原地修改', '转置时只交换对角线一侧', '行反转只遍历到中点'],
      solutions: [solution('transpose-reverse', '转置后反转行', '最优', '用两次简单的对称操作完成坐标映射。', ['交换 matrix[row][column] 与 matrix[column][row]', '遍历每一行', '对每行执行左右双指针反转'], 'O(n²)', 'O(1)',
        `class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) for (int column = row + 1; column < n; column++) { int value = matrix[row][column]; matrix[row][column] = matrix[column][row]; matrix[column][row] = value; }
        for (int[] row : matrix) for (int left = 0, right = n - 1; left < right; left++, right--) { int value = row[left]; row[left] = row[right]; row[right] = value; }
    }
}`,
        `class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val n = matrix.size
        for (row in 0 until n) for (column in row + 1 until n) { val value = matrix[row][column]; matrix[row][column] = matrix[column][row]; matrix[column][row] = value }
        for (row in matrix) { var left = 0; var right = n - 1; while (left < right) { val value = row[left]; row[left++] = row[right]; row[right--] = value } }
    }
}`,
        `class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        for (int row = 0; row < n; ++row) for (int column = row + 1; column < n; ++column) swap(matrix[row][column], matrix[column][row]);
        for (auto& row : matrix) reverse(row.begin(), row.end());
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'rotate', parameterTypes: ['intMatrix'], returnType: 'void', cases: [
        { name: '三阶矩阵顺时针旋转', args: [[[1, 2, 3], [4, 5, 6], [7, 8, 9]]], expectedArgs: [{ index: 0, type: 'intMatrix', expected: [[7, 4, 1], [8, 5, 2], [9, 6, 3]] }] },
        { name: '四阶矩阵顺时针旋转', args: [[[5, 1, 9, 11], [2, 4, 8, 10], [13, 3, 6, 7], [15, 14, 12, 16]]], expectedArgs: [{ index: 0, type: 'intMatrix', expected: [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]] }] },
        { name: '单元素矩阵', args: [[[1]]], expectedArgs: [{ index: 0, type: 'intMatrix', expected: [[1]] }] },
      ] },
    },
  ],
}
