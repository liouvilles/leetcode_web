const solution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-002',
  problems: [
    {
      id: 74, slug: 'search-a-2d-matrix', title: '搜索二维矩阵',
      studyTags: ['二维二分', '下标映射', '整体有序'],
      summary: '矩阵每行递增，且下一行首元素大于上一行末元素，判断目标值是否存在。',
      insight: '矩阵按行展开后是一个完整升序数组，可把一维中点映射为 row=mid/columns、column=mid%columns。',
      pitfalls: ['总元素数量为 rows×columns', '一维右边界是总数减一', '映射除数必须是列数'],
      solutions: [solution('flattened-binary-search', '虚拟展开二分', '最优', '不复制矩阵，只用坐标换算在虚拟一维数组上二分。', ['建立 [0,mn-1] 闭区间', '把中点换算成行列坐标', '根据中点值更新二分边界'], 'O(log(mn))', 'O(1)',
        `class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int columns = matrix[0].length, left = 0, right = matrix.length * columns - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = matrix[middle / columns][middle % columns];
            if (value == target) return true;
            if (value < target) left = middle + 1; else right = middle - 1;
        }
        return false;
    }
}`,
        `class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val columns = matrix[0].size
        var left = 0
        var right = matrix.size * columns - 1
        while (left <= right) { val middle = left + (right - left) / 2; val value = matrix[middle / columns][middle % columns]; if (value == target) return true; if (value < target) left = middle + 1 else right = middle - 1 }
        return false
    }
}`,
        `class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int columns = matrix[0].size(), left = 0, right = matrix.size() * columns - 1;
        while (left <= right) { int middle = left + (right - left) / 2; int value = matrix[middle / columns][middle % columns]; if (value == target) return true; if (value < target) left = middle + 1; else right = middle - 1; }
        return false;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'searchMatrix', parameterTypes: ['intMatrix', 'int'], returnType: 'boolean', cases: [
        { name: '目标位于中间行', args: [[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 3], expected: true },
        { name: '目标落在相邻元素之间', args: [[[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 13], expected: false },
        { name: '单格矩阵命中', args: [[[1]], 1], expected: true },
      ] },
    },
    {
      id: 75, slug: 'sort-colors', title: '颜色分类',
      studyTags: ['荷兰国旗', '三指针', '原地排序'],
      summary: '把只包含 0、1、2 的数组原地排序，使相同数字相邻并按 0、1、2 排列。',
      insight: '维护已放好 0 的左区间和已放好 2 的右区间，中间指针处理尚未分类的值。',
      pitfalls: ['交换到右侧的值尚未检查，middle 不能立即递增', '交换零后 middle 可以前进', '循环条件包含 right 所在位置'],
      solutions: [solution('dutch-national-flag', '荷兰国旗三指针', '最优', '一次扫描把 0 交换到左端、2 交换到右端，1 留在中部。', ['left、middle 从零开始，right 从末尾开始', '遇 0 与 left 交换并同时前进', '遇 2 与 right 交换且只收缩 right'], 'O(n)', 'O(1)',
        `class Solution {
    public void sortColors(int[] nums) {
        int left = 0, middle = 0, right = nums.length - 1;
        while (middle <= right) {
            if (nums[middle] == 0) { swap(nums, left++, middle++); }
            else if (nums[middle] == 2) { swap(nums, middle, right--); }
            else middle++;
        }
    }
    private void swap(int[] nums, int first, int second) { int value = nums[first]; nums[first] = nums[second]; nums[second] = value; }
}`,
        `class Solution {
    fun sortColors(nums: IntArray) {
        var left = 0; var middle = 0; var right = nums.lastIndex
        while (middle <= right) {
            when (nums[middle]) { 0 -> swap(nums, left++, middle++); 2 -> swap(nums, middle, right--); else -> middle++ }
        }
    }
    private fun swap(nums: IntArray, first: Int, second: Int) { val value = nums[first]; nums[first] = nums[second]; nums[second] = value }
}`,
        `class Solution {
public:
    void sortColors(vector<int>& nums) {
        int left = 0, middle = 0, right = nums.size() - 1;
        while (middle <= right) { if (nums[middle] == 0) swap(nums[left++], nums[middle++]); else if (nums[middle] == 2) swap(nums[middle], nums[right--]); else ++middle; }
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'sortColors', parameterTypes: ['intArray'], returnType: 'void', cases: [
        { name: '三种颜色混合', args: [[2, 0, 2, 1, 1, 0]], expectedArgs: [{ index: 0, type: 'intArray', expected: [0, 0, 1, 1, 2, 2] }] },
        { name: '短数组逆序', args: [[2, 0, 1]], expectedArgs: [{ index: 0, type: 'intArray', expected: [0, 1, 2] }] },
        { name: '单一颜色', args: [[1, 1]], expectedArgs: [{ index: 0, type: 'intArray', expected: [1, 1] }] },
      ] },
    },
    {
      id: 84, slug: 'largest-rectangle-in-histogram', title: '柱状图中最大的矩形',
      studyTags: ['单调栈', '左右边界', '哨兵'],
      summary: '柱状图每根柱宽度为一，求由连续柱子组成的最大轴对齐矩形面积。',
      insight: '当遇到更矮柱子时，栈顶高度的右边界确定；弹栈后新栈顶就是它左侧第一个更矮位置。',
      pitfalls: ['面积宽度是 right-left-1', '末尾需要哨兵触发剩余柱子出栈', '栈中保存下标而不是高度'],
      solutions: [solution('monotonic-stack', '递增单调栈', '最优', '维护高度非递减的下标栈，并在高度下降时结算被弹出柱子的最大宽度。', ['压入左侧哨兵下标 -1', '当前高度更小时反复弹栈计算面积', '扫描到 n 时使用高度零的右哨兵'], 'O(n)', 'O(n)',
        `class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int best = 0;
        for (int index = 0; index <= heights.length; index++) {
            int height = index == heights.length ? 0 : heights[index];
            while (stack.peek() != -1 && heights[stack.peek()] > height) {
                int rectangleHeight = heights[stack.pop()];
                best = Math.max(best, rectangleHeight * (index - stack.peek() - 1));
            }
            stack.push(index);
        }
        return best;
    }
}`,
        `class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack: ArrayDeque<Int> = ArrayDeque()
        stack.addLast(-1)
        var best = 0
        for (index in 0..heights.size) {
            val height = if (index == heights.size) 0 else heights[index]
            while (stack.last() != -1 && heights[stack.last()] > height) { val rectangleHeight = heights[stack.removeLast()]; best = maxOf(best, rectangleHeight * (index - stack.last() - 1)) }
            stack.addLast(index)
        }
        return best
    }
}`,
        `class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> stack = {-1};
        int best = 0;
        for (int index = 0; index <= (int)heights.size(); ++index) {
            int height = index == (int)heights.size() ? 0 : heights[index];
            while (stack.back() != -1 && heights[stack.back()] > height) { int rectangleHeight = heights[stack.back()]; stack.pop_back(); best = max(best, rectangleHeight * (index - stack.back() - 1)); }
            stack.push_back(index);
        }
        return best;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'largestRectangleArea', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '中间两柱形成最大矩形', args: [[2, 1, 5, 6, 2, 3]], expected: 10 },
        { name: '两柱高度递增', args: [[2, 4]], expected: 4 },
        { name: '全等高柱子', args: [[2, 2, 2]], expected: 6 },
      ] },
    },
    {
      id: 88, slug: 'merge-sorted-array', title: '合并两个有序数组',
      studyTags: ['逆向双指针', '原地合并', '尾部写入'],
      summary: '把两个非递减数组合并进第一个数组；第一个数组尾部已经预留足够空间。',
      insight: '从两个有效区间的末尾比较，把较大值写到预留空间末尾，就不会覆盖尚未读取的数据。',
      pitfalls: ['nums1 只有前 m 个元素有效', 'nums2 剩余元素必须复制', 'nums1 剩余元素已经在正确位置无需处理'],
      solutions: [solution('reverse-two-pointers', '尾部逆向合并', '最优', '三个指针从后向前选择较大元素写入 nums1。', ['first=m-1、second=n-1、write=m+n-1', '比较两个末尾并写入较大值', '循环直到 nums2 全部写入'], 'O(m+n)', 'O(1)',
        `class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1, second = n - 1, write = m + n - 1;
        while (second >= 0) nums1[write--] = first >= 0 && nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
    }
}`,
        `class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var first = m - 1; var second = n - 1; var write = m + n - 1
        while (second >= 0) nums1[write--] = if (first >= 0 && nums1[first] > nums2[second]) nums1[first--] else nums2[second--]
    }
}`,
        `class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int first = m - 1, second = n - 1, write = m + n - 1;
        while (second >= 0) nums1[write--] = first >= 0 && nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'merge', parameterTypes: ['intArray', 'int', 'intArray', 'int'], returnType: 'void', cases: [
        { name: '两个数组交错合并', args: [[1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3], expectedArgs: [{ index: 0, type: 'intArray', expected: [1, 2, 2, 3, 5, 6] }] },
        { name: '第二数组为空', args: [[1], 1, [], 0], expectedArgs: [{ index: 0, type: 'intArray', expected: [1] }] },
        { name: '第一数组没有有效元素', args: [[0], 0, [1], 1], expectedArgs: [{ index: 0, type: 'intArray', expected: [1] }] },
      ] },
    },
    {
      id: 91, slug: 'decode-ways', title: '解码方法',
      studyTags: ['线性动态规划', '两位转移', '零的处理'],
      summary: '数字 1 到 26 分别映射字母，计算给定数字字符串有多少种完整解码方式。',
      insight: '当前位置可以由合法的单个数字接在前一前缀后，也可以由合法的两位数字接在前两位前缀后。',
      pitfalls: ['字符 0 不能单独解码', '两位数必须在 10 到 26 之间', '以零开头的字符串没有解码方式'],
      solutions: [solution('rolling-dp', '滚动前缀 DP', '最优', '维护前两个前缀的解码数量，并根据一位和两位合法性累加当前值。', ['空前缀计数为一', '当前字符非零时加入 previous', '两位数合法时加入 beforePrevious'], 'O(n)', 'O(1)',
        `class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int beforePrevious = 1, previous = 1;
        for (int index = 1; index < s.length(); index++) {
            int current = s.charAt(index) == '0' ? 0 : previous;
            int pair = (s.charAt(index - 1) - '0') * 10 + s.charAt(index) - '0';
            if (pair >= 10 && pair <= 26) current += beforePrevious;
            beforePrevious = previous;
            previous = current;
        }
        return previous;
    }
}`,
        `class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0
        var beforePrevious = 1; var previous = 1
        for (index in 1 until s.length) { var current = if (s[index] == '0') 0 else previous; val pair = (s[index - 1] - '0') * 10 + (s[index] - '0'); if (pair in 10..26) current += beforePrevious; beforePrevious = previous; previous = current }
        return previous
    }
}`,
        `class Solution {
public:
    int numDecodings(string s) {
        if (s[0] == '0') return 0;
        int beforePrevious = 1, previous = 1;
        for (int index = 1; index < (int)s.size(); ++index) { int current = s[index] == '0' ? 0 : previous; int pair = (s[index - 1] - '0') * 10 + s[index] - '0'; if (pair >= 10 && pair <= 26) current += beforePrevious; beforePrevious = previous; previous = current; }
        return previous;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'numDecodings', parameterTypes: ['string'], returnType: 'int', cases: [
        { name: '两种拆分方式', args: ['12'], expected: 2 },
        { name: '三种拆分方式', args: ['226'], expected: 3 },
        { name: '前导零不可解码', args: ['06'], expected: 0 },
      ] },
    },
  ],
}
