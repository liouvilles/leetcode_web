const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 92, slug: 'reverse-linked-list-ii', title: '反转链表 II', studyTags: ['链表', '头插法', '局部反转'],
    summary: '只反转单链表从 left 到 right 的连续节点区间，并返回修改后的头节点。',
    insight: '找到区间前驱后，把区间内后续节点逐个摘下并插到区间最前方，可一次扫描原地完成。',
    pitfalls: ['left 可能等于一，需要哑节点', '区间长度为一时无需移动', '每次头插都要保留被摘节点的后继'],
    solutions: [s('front-insertion', '区间头插反转', '固定区间前驱和区间原首节点，将其后的节点依次插到前驱之后。', ['走到 left 前一个节点', '重复摘下 current.next', '把摘下节点插到 previous.next'], 'O(n)', 'O(1)',
      `class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head), previous = dummy; for (int position = 1; position < left; position++) previous = previous.next;
        ListNode current = previous.next;
        for (int count = 0; count < right - left; count++) { ListNode moved = current.next; current.next = moved.next; moved.next = previous.next; previous.next = moved; }
        return dummy.next;
    }
}`,
      `class Solution {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        val dummy = ListNode(0); dummy.next = head; var previous = dummy; for (position in 1 until left) previous = previous.next!!
        val current = previous.next!!
        repeat(right - left) { val moved = current.next!!; current.next = moved.next; moved.next = previous.next; previous.next = moved }
        return dummy.next
    }
}`,
      `class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        ListNode dummy(0, head); ListNode* previous = &dummy; for (int position = 1; position < left; ++position) previous = previous->next;
        ListNode* current = previous->next;
        for (int count = 0; count < right - left; ++count) { ListNode* moved = current->next; current->next = moved->next; moved->next = previous->next; previous->next = moved; } return dummy.next;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'reverseBetween', parameterTypes: ['listNode','int','int'], returnType: 'listNode', cases: [
      { name: '反转中间区间', args: [[1,2,3,4,5],2,4], expected: [1,4,3,2,5] }, { name: '单节点区间', args: [[5],1,1], expected: [5] }, { name: '反转整个链表', args: [[3,5],1,2], expected: [5,3] },
    ] },
  },
  {
    id: 93, slug: 'restore-ip-addresses', title: '复原 IP 地址', studyTags: ['回溯', '字符串分段', '剪枝'],
    summary: '在只含数字的字符串中插入三个点，返回所有每段在 0 到 255 且格式合法的 IPv4 地址。',
    insight: '深度固定为四段，每段尝试一到三位；用剩余字符数与剩余段数的范围提前剪枝。',
    pitfalls: ['多位段不能以零开头', '段值不能超过 255', '必须恰好使用全部字符并得到四段'],
    solutions: [s('four-segment-backtracking', '四段回溯', '按顺序枚举每段长度，合法时递归构造下一段。', ['检查剩余字符能否填满剩余段', '尝试长度 1..3 并校验前导零和值', '四段且用完字符串时加入答案'], 'O(1)', 'O(1) excluding output',
      `class Solution {
    public List<String> restoreIpAddresses(String s) { List<String> answer = new ArrayList<>(); backtrack(s, 0, new ArrayList<>(), answer); return answer; }
    private void backtrack(String s, int index, List<String> parts, List<String> answer) {
        int remainingParts = 4 - parts.size(), remainingChars = s.length() - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;
        if (parts.size() == 4) { if (index == s.length()) answer.add(String.join(".", parts)); return; }
        int value = 0; for (int end = index; end < Math.min(index + 3, s.length()); end++) { if (end > index && s.charAt(index) == '0') break; value = value * 10 + s.charAt(end) - '0'; if (value > 255) break; parts.add(s.substring(index, end + 1)); backtrack(s, end + 1, parts, answer); parts.remove(parts.size() - 1); }
    }
}`,
      `class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val answer = mutableListOf<String>(); val parts = mutableListOf<String>()
        fun backtrack(index: Int) { val remainingParts = 4 - parts.size; val remainingChars = s.length - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return; if (parts.size == 4) { if (index == s.length) answer.add(parts.joinToString(".")); return }; var value = 0; for (end in index until minOf(index + 3, s.length)) { if (end > index && s[index] == '0') break; value = value * 10 + (s[end] - '0'); if (value > 255) break; parts.add(s.substring(index, end + 1)); backtrack(end + 1); parts.removeAt(parts.lastIndex) } }
        backtrack(0); return answer
    }
}`,
      `class Solution {
    void backtrack(const string& s, int index, vector<string>& parts, vector<string>& answer) {
        int remainingParts = 4 - parts.size(), remainingChars = s.size() - index; if (remainingChars < remainingParts || remainingChars > remainingParts * 3) return;
        if (parts.size() == 4) { if (index == (int)s.size()) { string address = parts[0]; for (int i = 1; i < 4; ++i) address += "." + parts[i]; answer.push_back(address); } return; }
        int value = 0; for (int end = index; end < min(index + 3, (int)s.size()); ++end) { if (end > index && s[index] == '0') break; value = value * 10 + s[end] - '0'; if (value > 255) break; parts.push_back(s.substr(index, end - index + 1)); backtrack(s, end + 1, parts, answer); parts.pop_back(); }
    }
public:
    vector<string> restoreIpAddresses(string s) { vector<string> answer, parts; backtrack(s, 0, parts, answer); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'restoreIpAddresses', parameterTypes: ['string'], returnType: 'stringList', cases: [
      { name: '两种复原方式', args: ['25525511135'], expected: ['255.255.11.135','255.255.111.35'] }, { name: '全零字符串', args: ['0000'], expected: ['0.0.0.0'] }, { name: '多种分段', args: ['101023'], expected: ['1.0.10.23','1.0.102.3','10.1.0.23','10.10.2.3','101.0.2.3'] },
    ] },
  },
  {
    id: 96, slug: 'unique-binary-search-trees', title: '不同的二叉搜索树', studyTags: ['动态规划', '卡特兰数', '树形计数'],
    summary: '计算由 1 到 n 组成且节点值各不相同的二叉搜索树一共有多少种结构。',
    insight: '选择 root 后，左右子树的节点数量确定且结构选择相互独立；枚举根并累加左右方案数乘积。',
    pitfalls: ['空子树的方案数为一', '只与节点数量有关而与具体值无关', '每个根都要计入总和'],
    solutions: [s('catalan-dp', '卡特兰动态规划', 'dp[nodes] 表示给定节点数的不同 BST 数量，通过根位置划分左右规模。', ['dp[0]=dp[1]=1', '枚举总节点数', '枚举左子树节点数并累加 dp[left]*dp[right]'], 'O(n²)', 'O(n)',
      `class Solution {
    public int numTrees(int n) { int[] dp = new int[n + 1]; dp[0] = 1; for (int nodes = 1; nodes <= n; nodes++) for (int left = 0; left < nodes; left++) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n]; }
}`,
      `class Solution {
    fun numTrees(n: Int): Int { val dp = IntArray(n + 1); dp[0] = 1; for (nodes in 1..n) for (left in 0 until nodes) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n] }
}`,
      `class Solution {
public:
    int numTrees(int n) { vector<int> dp(n + 1); dp[0] = 1; for (int nodes = 1; nodes <= n; ++nodes) for (int left = 0; left < nodes; ++left) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n]; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'numTrees', parameterTypes: ['int'], returnType: 'int', cases: [
      { name: '三个节点', args: [3], expected: 5 }, { name: '一个节点', args: [1], expected: 1 }, { name: '五个节点', args: [5], expected: 42 },
    ] },
  },
  {
    id: 97, slug: 'interleaving-string', title: '交错字符串', studyTags: ['动态规划', '字符串', '滚动数组'],
    summary: '判断第三个字符串能否在保持前两个字符串各自字符顺序的前提下，由它们交错组成。',
    insight: '状态 (i,j) 只可能由取 s1 的最后一个字符或取 s2 的最后一个字符转移，一维数组即可滚动保存。',
    pitfalls: ['总长度不等时可立即返回假', '字符相同时两个转移都要保留', '更新 dp 时 dp[j] 是上一行而 dp[j-1] 是当前行'],
    solutions: [s('one-dimensional-dp', '一维交错动态规划', 'dp[j] 表示当前使用 s1 前 i 个和 s2 前 j 个字符时能否匹配。', ['先检查长度和', '逐行逐列计算来自 s1 或 s2 的转移', '返回 dp[s2.length]'], 'O(mn)', 'O(n)',
      `class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false; boolean[] dp = new boolean[s2.length() + 1]; dp[0] = true;
        for (int i = 0; i <= s1.length(); i++) for (int j = 0; j <= s2.length(); j++) { if (i == 0 && j == 0) continue; boolean first = i > 0 && dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1); boolean second = j > 0 && dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1); dp[j] = first || second; }
        return dp[s2.length()];
    }
}`,
      `class Solution {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false; val dp = BooleanArray(s2.length + 1); dp[0] = true
        for (i in 0..s1.length) for (j in 0..s2.length) { if (i == 0 && j == 0) continue; val first = i > 0 && dp[j] && s1[i - 1] == s3[i + j - 1]; val second = j > 0 && dp[j - 1] && s2[j - 1] == s3[i + j - 1]; dp[j] = first || second }
        return dp[s2.length]
    }
}`,
      `class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.size() + s2.size() != s3.size()) return false; vector<bool> dp(s2.size() + 1); dp[0] = true;
        for (int i = 0; i <= (int)s1.size(); ++i) for (int j = 0; j <= (int)s2.size(); ++j) { if (i == 0 && j == 0) continue; bool first = i > 0 && dp[j] && s1[i - 1] == s3[i + j - 1]; bool second = j > 0 && dp[j - 1] && s2[j - 1] == s3[i + j - 1]; dp[j] = first || second; } return dp[s2.size()];
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'isInterleave', parameterTypes: ['string','string','string'], returnType: 'boolean', cases: [
      { name: '存在合法交错', args: ['aabcc','dbbca','aadbbcbcac'], expected: true }, { name: '顺序无法满足', args: ['aabcc','dbbca','aadbbbaccc'], expected: false }, { name: '三个空串', args: ['','',''], expected: true },
    ] },
  },
  {
    id: 103, slug: 'binary-tree-zigzag-level-order-traversal', title: '二叉树的锯齿形层序遍历', studyTags: ['二叉树', '广度优先搜索', '方向切换'],
    summary: '按层遍历二叉树，并让相邻层的节点值输出方向在从左到右与从右到左之间交替。',
    insight: '队列仍按普通层序顺序扩展节点，只需根据层方向把值写入本层数组的正向或反向下标。',
    pitfalls: ['改变的是输出顺序而非子节点入队顺序', '每处理完一层再切换方向', '空树返回空列表'],
    solutions: [s('bfs-index-placement', '层序遍历按方向写入', '逐层固定大小出队，并用镜像下标生成锯齿顺序。', ['根节点入队', '按当前层 size 创建列表', '值写入 index 或 size-1-index，子节点正常入队，随后切换方向'], 'O(n)', 'O(w)',
      `class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>(); if (root == null) return answer; Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root); boolean leftToRight = true;
        while (!queue.isEmpty()) { int size = queue.size(); Integer[] level = new Integer[size]; for (int index = 0; index < size; index++) { TreeNode node = queue.poll(); level[leftToRight ? index : size - 1 - index] = node.val; if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } answer.add(Arrays.asList(level)); leftToRight = !leftToRight; }
        return answer;
    }
}`,
      `class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList(); val answer = mutableListOf<List<Int>>(); val queue = ArrayDeque<TreeNode>(); queue.add(root); var leftToRight = true
        while (queue.isNotEmpty()) { val size = queue.size; val level = MutableList(size) { 0 }; repeat(size) { index -> val node = queue.removeFirst(); level[if (leftToRight) index else size - 1 - index] = node.\`val\`; node.left?.let { queue.add(it) }; node.right?.let { queue.add(it) } }; answer.add(level); leftToRight = !leftToRight }
        return answer
    }
}`,
      `class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if (!root) return {}; vector<vector<int>> answer; queue<TreeNode*> nodes; nodes.push(root); bool leftToRight = true;
        while (!nodes.empty()) { int size = nodes.size(); vector<int> level(size); for (int index = 0; index < size; ++index) { TreeNode* node = nodes.front(); nodes.pop(); level[leftToRight ? index : size - 1 - index] = node->val; if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } answer.push_back(level); leftToRight = !leftToRight; } return answer;
    }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'zigzagLevelOrder', parameterTypes: ['treeNode'], returnType: 'intListMatrix', cases: [
      { name: '三层锯齿遍历', args: [[3,9,20,null,null,15,7]], expected: [[3],[20,9],[15,7]] }, { name: '单节点', args: [[1]], expected: [[1]] }, { name: '空树', args: [[]], expected: [] },
    ] },
  },
] }
