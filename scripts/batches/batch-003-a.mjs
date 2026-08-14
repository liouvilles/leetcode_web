const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 153, slug: 'find-minimum-in-rotated-sorted-array', title: '寻找旋转排序数组中的最小值',
      studyTags: ['二分查找', '旋转数组', '右端比较'],
      summary: '在元素互不相同、经过若干次旋转的升序数组中找出最小元素。',
      insight: '把中点与右端比较：中点更大说明最小值在右侧，否则中点仍可能是答案，应保留在左半区。',
      pitfalls: ['右边界更新为 middle 而不是 middle-1', '未旋转数组也要正确处理', '元素互不相同，因此没有相等分支的歧义'],
      solutions: [s('binary-search', '与右端比较的二分', '最优', '利用旋转后两段有序区间的相对大小定位断点。', ['维护包含最小值的闭区间', 'middle 大于 right 时移动 left', '否则保留 middle 并收缩 right'], 'O(log n)', 'O(1)',
        `class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else right = middle; }
        return nums[left];
    }
}`,
        `class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0; var right = nums.lastIndex
        while (left < right) { val middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1 else right = middle }
        return nums[left]
    }
}`,
        `class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        while (left < right) { int middle = left + (right - left) / 2; if (nums[middle] > nums[right]) left = middle + 1; else right = middle; }
        return nums[left];
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'findMin', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '旋转点位于中部', args: [[3, 4, 5, 1, 2]], expected: 1 },
        { name: '旋转点靠近末尾', args: [[4, 5, 6, 7, 0, 1, 2]], expected: 0 },
        { name: '未旋转数组', args: [[11, 13, 15, 17]], expected: 11 },
      ] },
    },
    {
      id: 155, slug: 'min-stack', title: '最小栈',
      studyTags: ['设计题', '辅助栈', '同步最小值'],
      summary: '设计支持压栈、出栈、读取栈顶和常数时间获取当前最小元素的栈。',
      insight: '每个入栈位置同时保存截至该位置的最小值，出栈时两个状态自然同步回退。',
      pitfalls: ['重复最小值需要分别记录', 'getMin 不能线性扫描', '题目保证只在非空栈执行读取和弹出'],
      solutions: [s('paired-values', '值与前缀最小值成对入栈', '最优', '每个栈元素保存原值和加入它之后的最小值。', ['push 时比较当前值与旧最小值', 'pop 删除一整对状态', 'top 和 getMin 分别读取栈顶的两个字段'], 'O(1)', 'O(n)',
        `class MinStack {
    private final Deque<int[]> stack = new ArrayDeque<>();
    public MinStack() {}
    public void push(int value) { int minimum = stack.isEmpty() ? value : Math.min(value, stack.peek()[1]); stack.push(new int[] {value, minimum}); }
    public void pop() { stack.pop(); }
    public int top() { return stack.peek()[0]; }
    public int getMin() { return stack.peek()[1]; }
}`,
        `class MinStack {
    private val stack = ArrayDeque<IntArray>()
    fun push(value: Int) { val minimum = if (stack.isEmpty()) value else minOf(value, stack.last()[1]); stack.addLast(intArrayOf(value, minimum)) }
    fun pop() { stack.removeLast() }
    fun top(): Int = stack.last()[0]
    fun getMin(): Int = stack.last()[1]
}`,
        `class MinStack {
    vector<pair<int, int>> stack;
public:
    MinStack() {}
    void push(int value) { int minimum = stack.empty() ? value : min(value, stack.back().second); stack.push_back({value, minimum}); }
    void pop() { stack.pop_back(); }
    int top() { return stack.back().first; }
    int getMin() { return stack.back().second; }
};`)],
      tests: { schemaVersion: 1, mode: 'design', className: 'MinStack', constructorTypes: [], cases: [
        { name: '弹出最小值后恢复旧最小值', constructorArgs: [], calls: [
          { method: 'push', parameterTypes: ['int'], args: [-2] }, { method: 'push', parameterTypes: ['int'], args: [0] }, { method: 'push', parameterTypes: ['int'], args: [-3] },
          { method: 'getMin', parameterTypes: [], args: [], returnType: 'int', expected: -3 }, { method: 'pop', parameterTypes: [], args: [] },
          { method: 'top', parameterTypes: [], args: [], returnType: 'int', expected: 0 }, { method: 'getMin', parameterTypes: [], args: [], returnType: 'int', expected: -2 },
        ] },
        { name: '重复最小值', constructorArgs: [], calls: [
          { method: 'push', parameterTypes: ['int'], args: [1] }, { method: 'push', parameterTypes: ['int'], args: [1] }, { method: 'pop', parameterTypes: [], args: [] },
          { method: 'getMin', parameterTypes: [], args: [], returnType: 'int', expected: 1 },
        ] },
        { name: '单元素栈', constructorArgs: [], calls: [
          { method: 'push', parameterTypes: ['int'], args: [5] }, { method: 'top', parameterTypes: [], args: [], returnType: 'int', expected: 5 },
          { method: 'getMin', parameterTypes: [], args: [], returnType: 'int', expected: 5 },
        ] },
      ] },
    },
    {
      id: 189, slug: 'rotate-array', title: '轮转数组',
      studyTags: ['三次反转', '原地数组', '模运算'],
      summary: '把数组中的元素整体向右轮转 k 个位置，要求原地完成。',
      insight: '先反转整个数组，再分别反转前 k 个和后 n-k 个元素，就能保持两段内部的原顺序。',
      pitfalls: ['k 需要对数组长度取模', 'k 为零时通用反转流程仍可处理', '反转区间边界都包含端点'],
      solutions: [s('three-reversals', '三次区间反转', '最优', '通过整体反转与两段局部反转实现原地循环移动。', ['令 k %= n', '反转整个数组', '反转 [0,k-1] 和 [k,n-1]'], 'O(n)', 'O(1)',
        `class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); reverse(nums, 0, k - 1); reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int left, int right) { while (left < right) { int value = nums[left]; nums[left++] = nums[right]; nums[right--] = value; } }
}`,
        `class Solution {
    fun rotate(nums: IntArray, shift: Int) {
        val k = shift % nums.size
        reverse(nums, 0, nums.lastIndex); reverse(nums, 0, k - 1); reverse(nums, k, nums.lastIndex)
    }
    private fun reverse(nums: IntArray, start: Int, end: Int) { var left = start; var right = end; while (left < right) { val value = nums[left]; nums[left++] = nums[right]; nums[right--] = value } }
}`,
        `class Solution {
    void reverseRange(vector<int>& nums, int left, int right) { while (left < right) swap(nums[left++], nums[right--]); }
public:
    void rotate(vector<int>& nums, int k) {
        k %= nums.size();
        reverseRange(nums, 0, nums.size() - 1); reverseRange(nums, 0, k - 1); reverseRange(nums, k, nums.size() - 1);
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'rotate', parameterTypes: ['intArray', 'int'], returnType: 'void', cases: [
        { name: '向右轮转三位', args: [[1, 2, 3, 4, 5, 6, 7], 3], expectedArgs: [{ index: 0, type: 'intArray', expected: [5, 6, 7, 1, 2, 3, 4] }] },
        { name: '含负数的短数组', args: [[-1, -100, 3, 99], 2], expectedArgs: [{ index: 0, type: 'intArray', expected: [3, 99, -1, -100] }] },
        { name: '轮转次数大于长度', args: [[1, 2], 5], expectedArgs: [{ index: 0, type: 'intArray', expected: [2, 1] }] },
      ] },
    },
    {
      id: 199, slug: 'binary-tree-right-side-view', title: '二叉树的右视图',
      studyTags: ['层序遍历', '每层末尾', '广度优先搜索'],
      summary: '从二叉树右侧观察，返回从上到下每一层能够看到的节点值。',
      insight: '层序遍历时，每层队列中最后被处理的节点就是该层最右侧可见节点。',
      pitfalls: ['可见节点不一定沿着右孩子链', '每层开始时必须固定当前队列长度', '空树返回空列表'],
      solutions: [s('level-order-last', '层序记录末节点', '最优', '按层消费队列，并在每层最后一个下标保存节点值。', ['根节点入队', '固定当前层大小并逐个弹出', '处理到层末时把值加入答案'], 'O(n)', 'O(w)',
        `class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root);
        while (!queue.isEmpty()) { int size = queue.size(); for (int index = 0; index < size; index++) { TreeNode node = queue.poll(); if (index == size - 1) answer.add(node.val); if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } }
        return answer;
    }
}`,
        `class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val answer = ArrayList<Int>(); val queue: ArrayDeque<TreeNode> = ArrayDeque(); queue.add(root)
        while (queue.isNotEmpty()) { val size = queue.size; repeat(size) { index -> val node = queue.removeFirst(); if (index == size - 1) answer.add(node.\`val\`); node.left?.let(queue::add); node.right?.let(queue::add) } }
        return answer
    }
}`,
        `class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if (!root) return {};
        vector<int> answer; queue<TreeNode*> pending; pending.push(root);
        while (!pending.empty()) { int size = pending.size(); for (int index = 0; index < size; ++index) { TreeNode* node = pending.front(); pending.pop(); if (index == size - 1) answer.push_back(node->val); if (node->left) pending.push(node->left); if (node->right) pending.push(node->right); } }
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'rightSideView', parameterTypes: ['treeNode'], returnType: 'intList', cases: [
        { name: '右侧节点覆盖左侧', args: [[1, 2, 3, null, 5, null, 4]], expected: [1, 3, 4] },
        { name: '缺少右孩子时看到左孩子', args: [[1, 2, 3, 4]], expected: [1, 3, 4] },
        { name: '空树', args: [[]], expected: [] },
      ] },
    },
    {
      id: 202, slug: 'happy-number', title: '快乐数',
      studyTags: ['快慢指针', '数字变换', '环检测'],
      summary: '反复把整数替换为各位数字平方和；若最终到达 1 则为快乐数，否则会进入循环。',
      insight: '该确定性变换形成函数图，可以像链表判环一样用快慢指针判断是否到达 1 或陷入非 1 环。',
      pitfalls: ['每轮要处理所有十进制位', '非快乐数不会无限产生新值，而会成环', '快指针每轮执行两次变换'],
      solutions: [s('floyd-cycle', 'Floyd 环检测', '最优', '把数字视为节点、平方和视为后继，用快慢指针避免额外集合。', ['slow 走一步、fast 走两步', 'fast 到达 1 时成功', '两指针相遇且不为 1 时失败'], 'O(log n)', 'O(1)',
        `class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = next(n);
        while (fast != 1 && slow != fast) { slow = next(slow); fast = next(next(fast)); }
        return fast == 1;
    }
    private int next(int value) { int sum = 0; while (value > 0) { int digit = value % 10; sum += digit * digit; value /= 10; } return sum; }
}`,
        `class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n; var fast = next(n)
        while (fast != 1 && slow != fast) { slow = next(slow); fast = next(next(fast)) }
        return fast == 1
    }
    private fun next(input: Int): Int { var value = input; var sum = 0; while (value > 0) { val digit = value % 10; sum += digit * digit; value /= 10 }; return sum }
}`,
        `class Solution {
    int next(int value) { int sum = 0; while (value > 0) { int digit = value % 10; sum += digit * digit; value /= 10; } return sum; }
public:
    bool isHappy(int n) {
        int slow = n, fast = next(n);
        while (fast != 1 && slow != fast) { slow = next(slow); fast = next(next(fast)); }
        return fast == 1;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isHappy', parameterTypes: ['int'], returnType: 'boolean', cases: [
        { name: '多轮后到达一', args: [19], expected: true },
        { name: '进入非一循环', args: [2], expected: false },
        { name: '一自身是快乐数', args: [1], expected: true },
      ] },
    },
  ],
}
