const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 208, slug: 'implement-trie-prefix-tree', title: '实现 Trie（前缀树）',
      studyTags: ['设计题', '字典树', '前缀查询'],
      summary: '实现支持插入单词、查询完整单词和查询前缀是否存在的前缀树。',
      insight: '每个节点表示一个前缀，孩子边表示下一个字符；额外终止标记区分完整单词与普通前缀。',
      pitfalls: ['startsWith 不要求终止标记为真', '重复插入同一单词不会改变语义', '输入只包含小写英文字母'],
      solutions: [s('array-children', '定长孩子数组字典树', '最优', '每个节点用长度 26 的数组保存下一字符节点，并记录是否为单词结尾。', ['从根按字符逐层创建或读取节点', 'insert 最终设置 end 标记', 'search 与 startsWith 共用前缀定位逻辑'], 'O(L)', 'O(total characters)',
        `class Trie {
    private static class Node { Node[] children = new Node[26]; boolean end; }
    private final Node root = new Node();
    public Trie() {}
    public void insert(String word) { Node node = root; for (int index = 0; index < word.length(); index++) { int offset = word.charAt(index) - 'a'; if (node.children[offset] == null) node.children[offset] = new Node(); node = node.children[offset]; } node.end = true; }
    public boolean search(String word) { Node node = find(word); return node != null && node.end; }
    public boolean startsWith(String prefix) { return find(prefix) != null; }
    private Node find(String value) { Node node = root; for (int index = 0; index < value.length() && node != null; index++) node = node.children[value.charAt(index) - 'a']; return node; }
}`,
        `class Trie {
    private class Node { val children = arrayOfNulls<Node>(26); var end = false }
    private val root = Node()
    fun insert(word: String) { var node = root; for (char in word) { val offset = char - 'a'; if (node.children[offset] == null) node.children[offset] = Node(); node = node.children[offset]!! }; node.end = true }
    fun search(word: String): Boolean = find(word)?.end == true
    fun startsWith(prefix: String): Boolean = find(prefix) != null
    private fun find(value: String): Node? { var node: Node? = root; for (char in value) node = node?.children?.get(char - 'a'); return node }
}`,
        `class Trie {
    struct Node { array<Node*, 26> children{}; bool end = false; };
    Node* root = new Node();
    Node* find(const string& value) { Node* node = root; for (char letter : value) { node = node->children[letter - 'a']; if (!node) return nullptr; } return node; }
public:
    Trie() {}
    void insert(string word) { Node* node = root; for (char letter : word) { Node*& child = node->children[letter - 'a']; if (!child) child = new Node(); node = child; } node->end = true; }
    bool search(string word) { Node* node = find(word); return node && node->end; }
    bool startsWith(string prefix) { return find(prefix) != nullptr; }
};`)],
      tests: { schemaVersion: 1, mode: 'design', className: 'Trie', constructorTypes: [], cases: [
        { name: '区分完整单词和前缀', constructorArgs: [], calls: [
          { method: 'insert', parameterTypes: ['string'], args: ['apple'] },
          { method: 'search', parameterTypes: ['string'], args: ['apple'], returnType: 'boolean', expected: true },
          { method: 'search', parameterTypes: ['string'], args: ['app'], returnType: 'boolean', expected: false },
          { method: 'startsWith', parameterTypes: ['string'], args: ['app'], returnType: 'boolean', expected: true },
          { method: 'insert', parameterTypes: ['string'], args: ['app'] },
          { method: 'search', parameterTypes: ['string'], args: ['app'], returnType: 'boolean', expected: true },
        ] },
        { name: '不存在的首字符', constructorArgs: [], calls: [
          { method: 'insert', parameterTypes: ['string'], args: ['cat'] },
          { method: 'startsWith', parameterTypes: ['string'], args: ['d'], returnType: 'boolean', expected: false },
        ] },
        { name: '重复插入', constructorArgs: [], calls: [
          { method: 'insert', parameterTypes: ['string'], args: ['a'] }, { method: 'insert', parameterTypes: ['string'], args: ['a'] },
          { method: 'search', parameterTypes: ['string'], args: ['a'], returnType: 'boolean', expected: true },
        ] },
      ] },
    },
    {
      id: 209, slug: 'minimum-size-subarray-sum', title: '长度最小的子数组',
      studyTags: ['滑动窗口', '正数数组', '最短合法区间'],
      summary: '在正整数数组中找到元素和至少为 target 的最短连续子数组长度，不存在则返回零。',
      insight: '所有元素为正，右端扩张只会增大和，达到目标后左端收缩只会减小和，因此窗口指针都单调移动。',
      pitfalls: ['条件是和大于等于目标', '每次合法时都要尝试继续收缩', '没有合法窗口时返回零'],
      solutions: [s('sliding-window', '正数滑动窗口', '最优', '扩张右边界累加，窗口合法时反复移除左端并更新最短长度。', ['sum 加入当前右端值', 'sum>=target 时更新长度', '减去左端值并右移 left'], 'O(n)', 'O(1)',
        `class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, best = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) { sum += nums[right]; while (sum >= target) { best = Math.min(best, right - left + 1); sum -= nums[left++]; } }
        return best == Integer.MAX_VALUE ? 0 : best;
    }
}`,
        `class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0; var sum = 0; var best = Int.MAX_VALUE
        for (right in nums.indices) { sum += nums[right]; while (sum >= target) { best = minOf(best, right - left + 1); sum -= nums[left++] } }
        return if (best == Int.MAX_VALUE) 0 else best
    }
}`,
        `class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int left = 0, sum = 0, best = INT_MAX;
        for (int right = 0; right < (int)nums.size(); ++right) { sum += nums[right]; while (sum >= target) { best = min(best, right - left + 1); sum -= nums[left++]; } }
        return best == INT_MAX ? 0 : best;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'minSubArrayLen', parameterTypes: ['int', 'intArray'], returnType: 'int', cases: [
        { name: '两个元素达到目标', args: [7, [2, 3, 1, 2, 4, 3]], expected: 2 },
        { name: '单元素达到目标', args: [4, [1, 4, 4]], expected: 1 },
        { name: '总和仍不足', args: [11, [1, 1, 1, 1, 1, 1, 1, 1]], expected: 0 },
      ] },
    },
    {
      id: 210, slug: 'course-schedule-ii', title: '课程表 II',
      studyTags: ['拓扑排序', '入度', '课程顺序'],
      summary: '根据课程先修关系返回一个可以完成全部课程的学习顺序；若依赖图有环则返回空数组。',
      insight: '依次选择入度为零的课程并删除它的出边，得到的处理顺序就是一种拓扑序。',
      pitfalls: ['关系 [a,b] 表示 b 是 a 的先修课', '可能存在多个合法顺序', '处理数量不足 numCourses 时必须返回空数组'],
      solutions: [s('kahn-order', 'Kahn 拓扑序', '最优', '零入度队列逐步释放后继课程，同时写入结果数组。', ['建立邻接表与入度', '所有零入度课程入队', '弹出并减少后继入度，最后检查处理数量'], 'O(V+E)', 'O(V+E)',
        `class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(); for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses]; for (int[] edge : prerequisites) { graph.get(edge[1]).add(edge[0]); indegree[edge[0]]++; }
        Queue<Integer> queue = new ArrayDeque<>(); for (int course = 0; course < numCourses; course++) if (indegree[course] == 0) queue.offer(course);
        int[] order = new int[numCourses]; int count = 0;
        while (!queue.isEmpty()) { int course = queue.poll(); order[count++] = course; for (int next : graph.get(course)) if (--indegree[next] == 0) queue.offer(next); }
        return count == numCourses ? order : new int[0];
    }
}`,
        `class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = List(numCourses) { ArrayList<Int>() }; val indegree = IntArray(numCourses)
        for (edge in prerequisites) { graph[edge[1]].add(edge[0]); indegree[edge[0]]++ }
        val queue: ArrayDeque<Int> = ArrayDeque(); for (course in 0 until numCourses) if (indegree[course] == 0) queue.add(course)
        val order = IntArray(numCourses); var count = 0
        while (queue.isNotEmpty()) { val course = queue.removeFirst(); order[count++] = course; for (next in graph[course]) { indegree[next]--; if (indegree[next] == 0) queue.add(next) } }
        return if (count == numCourses) order else intArrayOf()
    }
}`,
        `class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> graph(numCourses); vector<int> indegree(numCourses);
        for (const auto& edge : prerequisites) { graph[edge[1]].push_back(edge[0]); ++indegree[edge[0]]; }
        queue<int> pending; for (int course = 0; course < numCourses; ++course) if (indegree[course] == 0) pending.push(course);
        vector<int> order; while (!pending.empty()) { int course = pending.front(); pending.pop(); order.push_back(course); for (int next : graph[course]) if (--indegree[next] == 0) pending.push(next); }
        return order.size() == (size_t)numCourses ? order : vector<int>{};
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'findOrder', parameterTypes: ['int', 'intMatrix'], returnType: 'intArray', cases: [
        { name: '单条先修关系', args: [2, [[1, 0]]], expected: [0, 1] },
        { name: '分叉再汇合依赖', args: [4, [[1, 0], [2, 0], [3, 1], [3, 2]]], expected: [0, 1, 2, 3] },
        { name: '依赖成环', args: [2, [[1, 0], [0, 1]]], expected: [] },
      ] },
    },
    {
      id: 213, slug: 'house-robber-ii', title: '打家劫舍 II',
      studyTags: ['环形动态规划', '分类讨论', '滚动状态'],
      summary: '房屋首尾相邻围成一圈，不能选择相邻房屋，求可获得的最大金额。',
      insight: '首尾不能同时选择，最优解一定属于“不选最后一间”或“不选第一间”两个线性问题之一。',
      pitfalls: ['单间房屋需要单独处理', '两个线性区间分别是 [0,n-2] 与 [1,n-1]', '线性状态仍是相邻互斥'],
      solutions: [s('split-circle', '拆成两个线性区间', '最优', '分别计算排除首间和排除末间的线性打劫最优值并取最大。', ['单元素直接返回', '滚动 DP 计算前 n-1 间', '滚动 DP 计算后 n-1 间并取较大值'], 'O(n)', 'O(1)',
        `class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(linear(nums, 0, nums.length - 2), linear(nums, 1, nums.length - 1));
    }
    private int linear(int[] nums, int start, int end) { int before = 0, previous = 0; for (int index = start; index <= end; index++) { int current = Math.max(previous, before + nums[index]); before = previous; previous = current; } return previous; }
}`,
        `class Solution {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(linear(nums, 0, nums.size - 2), linear(nums, 1, nums.lastIndex))
    }
    private fun linear(nums: IntArray, start: Int, end: Int): Int { var before = 0; var previous = 0; for (index in start..end) { val current = maxOf(previous, before + nums[index]); before = previous; previous = current }; return previous }
}`,
        `class Solution {
    int linear(const vector<int>& nums, int start, int end) { int before = 0, previous = 0; for (int index = start; index <= end; ++index) { int current = max(previous, before + nums[index]); before = previous; previous = current; } return previous; }
public:
    int rob(vector<int>& nums) { if (nums.size() == 1) return nums[0]; return max(linear(nums, 0, nums.size() - 2), linear(nums, 1, nums.size() - 1)); }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'rob', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '首尾冲突选择中间', args: [[2, 3, 2]], expected: 3 },
        { name: '排除首间得到最优', args: [[1, 2, 3, 1]], expected: 4 },
        { name: '单间房屋', args: [[1]], expected: 1 },
      ] },
    },
    {
      id: 230, slug: 'kth-smallest-element-in-a-bst', title: '二叉搜索树中第 K 小的元素',
      studyTags: ['中序遍历', '二叉搜索树', '迭代栈'],
      summary: '在二叉搜索树中找出按值升序排列后的第 k 个元素。',
      insight: '二叉搜索树中序遍历天然按升序产生节点，弹出栈中的第 k 个节点即可返回。',
      pitfalls: ['k 从一开始计数', '必须先沿左链压栈', '弹出节点后转向它的右子树'],
      solutions: [s('iterative-inorder', '迭代中序遍历', '最优', '显式栈逐个生成升序节点，并在第 k 次弹栈时停止。', ['沿当前节点左链入栈', '弹栈后递减 k', 'k 为零返回，否则转向右孩子'], 'O(h+k)', 'O(h)',
        `class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>(); TreeNode node = root;
        while (true) { while (node != null) { stack.push(node); node = node.left; } node = stack.pop(); if (--k == 0) return node.val; node = node.right; }
    }
}`,
        `class Solution {
    fun kthSmallest(root: TreeNode?, inputK: Int): Int {
        val stack: ArrayDeque<TreeNode> = ArrayDeque(); var node = root; var k = inputK
        while (true) { while (node != null) { stack.addLast(node); node = node.left }; node = stack.removeLast(); if (--k == 0) return node.\`val\`; node = node.right }
    }
}`,
        `class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<TreeNode*> stack; TreeNode* node = root;
        while (true) { while (node) { stack.push_back(node); node = node->left; } node = stack.back(); stack.pop_back(); if (--k == 0) return node->val; node = node->right; }
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'kthSmallest', parameterTypes: ['treeNode', 'int'], returnType: 'int', cases: [
        { name: '第三小节点位于根', args: [[3, 1, 4, null, 2], 1], expected: 1 },
        { name: '复杂搜索树第三小', args: [[5, 3, 6, 2, 4, null, null, 1], 3], expected: 3 },
        { name: '单节点树', args: [[1], 1], expected: 1 },
      ] },
    },
  ],
}
