const s = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-003',
  problems: [
    {
      id: 203, slug: 'remove-linked-list-elements', title: '移除链表元素',
      studyTags: ['虚拟头结点', '链表删除', '单次遍历'],
      summary: '删除单链表中所有值等于指定值的节点，并返回新的头节点。',
      insight: '虚拟头结点让删除原头节点与删除中间节点使用完全相同的前驱改线逻辑。',
      pitfalls: ['可能连续删除多个节点', '删除时 previous 不应前进', '所有节点都被删除时返回空链表'],
      solutions: [s('dummy-head', '虚拟头结点迭代删除', '最优', '让 current 始终检查 previous 的下一个节点，按条件跳过或前进。', ['dummy.next=head', '若 previous.next 值命中则跨过它', '否则 previous 向前移动'], 'O(n)', 'O(1)',
        `class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), previous = dummy;
        while (previous.next != null) { if (previous.next.val == val) previous.next = previous.next.next; else previous = previous.next; }
        return dummy.next;
    }
}`,
        `class Solution {
    fun removeElements(head: ListNode?, value: Int): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous: ListNode? = dummy
        while (previous?.next != null) { if (previous.next?.\`val\` == value) previous.next = previous.next?.next else previous = previous.next }
        return dummy.next
    }
}`,
        `class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode dummy(0, head); ListNode* previous = &dummy;
        while (previous->next) { if (previous->next->val == val) previous->next = previous->next->next; else previous = previous->next; }
        return dummy.next;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'removeElements', parameterTypes: ['listNode', 'int'], returnType: 'listNode', cases: [
        { name: '删除头中尾多个节点', args: [[1, 2, 6, 3, 4, 5, 6], 6], expected: [1, 2, 3, 4, 5] },
        { name: '空链表', args: [[], 1], expected: [] },
        { name: '删除全部节点', args: [[7, 7, 7], 7], expected: [] },
      ] },
    },
    {
      id: 205, slug: 'isomorphic-strings', title: '同构字符串',
      studyTags: ['双向映射', '一一对应', '字符串'],
      summary: '判断能否通过把第一个字符串中的每个字符统一替换为另一个字符得到第二个字符串，同时保持字符顺序。',
      insight: '映射必须是一一对应，因此既要保证 s→t 一致，也要保证 t→s 不被另一个字符占用。',
      pitfalls: ['不同源字符不能映射到同一个目标字符', '同一源字符的所有出现位置必须映射一致', '字符可以映射为自身'],
      solutions: [s('two-way-mapping', '双向字符映射', '最优', '扫描对应字符并同时维护两个方向的映射约束。', ['读取同一位置的两个字符', '任一方向已有映射则检查一致性', '两方向都未建立时同时登记'], 'O(n)', 'O(|Σ|)',
        `class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] forward = new int[256], backward = new int[256]; Arrays.fill(forward, -1); Arrays.fill(backward, -1);
        for (int index = 0; index < s.length(); index++) { int first = s.charAt(index), second = t.charAt(index); if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first; } else if (forward[first] != second || backward[second] != first) return false; }
        return true;
    }
}`,
        `class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val forward = IntArray(256) { -1 }; val backward = IntArray(256) { -1 }
        for (index in s.indices) { val first = s[index].code; val second = t[index].code; if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first } else if (forward[first] != second || backward[second] != first) return false }
        return true
    }
}`,
        `class Solution {
public:
    bool isIsomorphic(string s, string t) {
        array<int, 256> forward, backward; forward.fill(-1); backward.fill(-1);
        for (int index = 0; index < (int)s.size(); ++index) { unsigned char first = s[index], second = t[index]; if (forward[first] == -1 && backward[second] == -1) { forward[first] = second; backward[second] = first; } else if (forward[first] != second || backward[second] != first) return false; }
        return true;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isIsomorphic', parameterTypes: ['string', 'string'], returnType: 'boolean', cases: [
        { name: '两个字符稳定映射', args: ['egg', 'add'], expected: true },
        { name: '同一字符映射不一致', args: ['foo', 'bar'], expected: false },
        { name: '两个源字符争用目标字符', args: ['badc', 'baba'], expected: false },
      ] },
    },
    {
      id: 226, slug: 'invert-binary-tree', title: '翻转二叉树（迭代版）',
      studyTags: ['广度优先搜索', '节点交换', '二叉树'],
      summary: '交换二叉树中每个节点的左右子树并返回根节点。',
      insight: '树中每个非空节点都执行一次左右孩子交换即可，遍历顺序不影响最终结果。',
      pitfalls: ['空树直接返回空', '交换后应把新的左右孩子继续加入队列', '只交换根节点不足以翻转整棵树'],
      solutions: [s('breadth-first-swap', '层序交换左右孩子', '最优', '使用队列访问每个节点并交换两个孩子。', ['根为空直接返回', '节点出队后交换 left 与 right', '把非空孩子加入队列'], 'O(n)', 'O(w)',
        `class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root);
        while (!queue.isEmpty()) { TreeNode node = queue.poll(); TreeNode child = node.left; node.left = node.right; node.right = child; if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); }
        return root;
    }
}`,
        `class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        root ?: return null; val queue: ArrayDeque<TreeNode> = ArrayDeque(); queue.add(root)
        while (queue.isNotEmpty()) { val node = queue.removeFirst(); val child = node.left; node.left = node.right; node.right = child; node.left?.let(queue::add); node.right?.let(queue::add) }
        return root
    }
}`,
        `class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr; queue<TreeNode*> pending; pending.push(root);
        while (!pending.empty()) { TreeNode* node = pending.front(); pending.pop(); swap(node->left, node->right); if (node->left) pending.push(node->left); if (node->right) pending.push(node->right); }
        return root;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'invertTree', parameterTypes: ['treeNode'], returnType: 'treeNode', cases: [
        { name: '完整三层树', args: [[4, 2, 7, 1, 3, 6, 9]], expected: [4, 7, 2, 9, 6, 3, 1] },
        { name: '两层树', args: [[2, 1, 3]], expected: [2, 3, 1] },
        { name: '空树', args: [[]], expected: [] },
      ] },
    },
    {
      id: 279, slug: 'perfect-squares', title: '完全平方数',
      studyTags: ['完全背包', '动态规划', '最少数量'],
      summary: '求若干个完全平方数之和等于 n 时所需的最少项数，每个平方数可以重复使用。',
      insight: '把每个平方数视为可无限使用的物品，dp[value] 从所有 dp[value-square]+1 中取最小。',
      pitfalls: ['一也属于完全平方数，因此一定有解', '平方数可重复使用', '状态初始值要大于任何可能答案'],
      solutions: [s('complete-knapsack-dp', '最短组成动态规划', '最优', '从一到 n 依次计算每个整数的最少平方数数量。', ['dp[0]=0，其余初始化较大值', '枚举 value 的所有 square<=value', '更新 dp[value]=min(dp[value],dp[value-square]+1)'], 'O(n√n)', 'O(n)',
        `class Solution {
    public int numSquares(int n) {
        int[] count = new int[n + 1]; Arrays.fill(count, n + 1); count[0] = 0;
        for (int value = 1; value <= n; value++) for (int root = 1; root * root <= value; root++) count[value] = Math.min(count[value], count[value - root * root] + 1);
        return count[n];
    }
}`,
        `class Solution {
    fun numSquares(n: Int): Int {
        val count = IntArray(n + 1) { n + 1 }; count[0] = 0
        for (value in 1..n) { var root = 1; while (root * root <= value) { count[value] = minOf(count[value], count[value - root * root] + 1); root++ } }
        return count[n]
    }
}`,
        `class Solution {
public:
    int numSquares(int n) {
        vector<int> count(n + 1, n + 1); count[0] = 0;
        for (int value = 1; value <= n; ++value) for (int root = 1; root * root <= value; ++root) count[value] = min(count[value], count[value - root * root] + 1);
        return count[n];
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'numSquares', parameterTypes: ['int'], returnType: 'int', cases: [
        { name: '十二由三个四组成', args: [12], expected: 3 },
        { name: '十三由九加四组成', args: [13], expected: 2 },
        { name: '完全平方数自身', args: [16], expected: 1 },
      ] },
    },
    {
      id: 287, slug: 'find-the-duplicate-number', title: '寻找重复数',
      studyTags: ['Floyd 判环', '数组映射', '常数空间'],
      summary: '长度为 n+1 的数组只包含 1 到 n，找出唯一重复值；不能修改数组且只用常数额外空间。',
      insight: '把下标到 nums[index] 视为链表后继，重复值就是环入口，可用 Floyd 快慢指针定位。',
      pitfalls: ['返回的是重复值，也等于环入口下标', '第二阶段一个指针从起点零重新出发', '题目可能让重复值出现多次'],
      solutions: [s('floyd-entry', '函数图环入口', '最优', '先让快慢指针在环内相遇，再等速前进找到入口。', ['slow 走一步、fast 走两步直到相遇', 'finder 从下标零出发', 'finder 与 slow 同速移动，相遇位置即重复值'], 'O(n)', 'O(1)',
        `class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]]; }
        int finder = 0;
        while (finder != slow) { finder = nums[finder]; slow = nums[slow]; }
        return finder;
    }
}`,
        `class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var slow = nums[0]; var fast = nums[nums[0]]
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]] }
        var finder = 0
        while (finder != slow) { finder = nums[finder]; slow = nums[slow] }
        return finder
    }
}`,
        `class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) { slow = nums[slow]; fast = nums[nums[fast]]; }
        int finder = 0;
        while (finder != slow) { finder = nums[finder]; slow = nums[slow]; }
        return finder;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'findDuplicate', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '重复值三', args: [[1, 3, 4, 2, 2]], expected: 2 },
        { name: '重复值出现两次', args: [[3, 1, 3, 4, 2]], expected: 3 },
        { name: '最小规模数组', args: [[1, 1]], expected: 1 },
      ] },
    },
  ],
}
