const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 131, slug: 'palindrome-partitioning', title: '分割回文串', studyTags: ['回溯', '回文判断', '字符串分割'],
    summary: '把字符串分割为若干连续子串，返回所有使每个子串都是回文串的分割方案。',
    insight: '从当前起点枚举下一段的终点，只有该段为回文时才递归处理剩余后缀。',
    pitfalls: ['必须覆盖原字符串的全部字符', '单字符总是回文', '记录方案时需要复制当前路径'],
    solutions: [s('palindrome-backtracking', '枚举回文前缀回溯', '递归选择每个后缀的一个回文前缀，走到字符串末尾即形成方案。', ['枚举 end 从 start 到末尾', '双指针检查 s[start..end] 是否回文', '选择子串、递归 end+1、撤销选择'], 'O(n·2^n)', 'O(n)',
      `class Solution {
    public List<List<String>> partition(String s) { List<List<String>> answer = new ArrayList<>(); backtrack(s, 0, new ArrayList<>(), answer); return answer; }
    private void backtrack(String s, int start, List<String> path, List<List<String>> answer) { if (start == s.length()) { answer.add(new ArrayList<>(path)); return; } for (int end = start; end < s.length(); end++) if (isPalindrome(s, start, end)) { path.add(s.substring(start, end + 1)); backtrack(s, end + 1, path, answer); path.remove(path.size() - 1); } }
    private boolean isPalindrome(String s, int left, int right) { while (left < right) if (s.charAt(left++) != s.charAt(right--)) return false; return true; }
}`,
      `class Solution {
    fun partition(s: String): List<List<String>> { val answer = mutableListOf<List<String>>(); val path = mutableListOf<String>(); fun palindrome(start: Int, endValue: Int): Boolean { var left = start; var right = endValue; while (left < right) if (s[left++] != s[right--]) return false; return true }; fun backtrack(start: Int) { if (start == s.length) { answer.add(path.toList()); return }; for (endValue in start until s.length) if (palindrome(start, endValue)) { path.add(s.substring(start, endValue + 1)); backtrack(endValue + 1); path.removeAt(path.lastIndex) } }; backtrack(0); return answer }
}`,
      `class Solution {
    bool palindrome(const string& s, int left, int right) { while (left < right) if (s[left++] != s[right--]) return false; return true; }
    void backtrack(const string& s, int start, vector<string>& path, vector<vector<string>>& answer) { if (start == (int)s.size()) { answer.push_back(path); return; } for (int end = start; end < (int)s.size(); ++end) if (palindrome(s, start, end)) { path.push_back(s.substr(start, end - start + 1)); backtrack(s, end + 1, path, answer); path.pop_back(); } }
public:
    vector<vector<string>> partition(string s) { vector<vector<string>> answer; vector<string> path; backtrack(s, 0, path, answer); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'partition', parameterTypes: ['string'], returnType: 'stringListMatrix', cases: [
      { name: '单字与双字回文方案', args: ['aab'], expected: [['a','a','b'],['aa','b']] }, { name: '单字符', args: ['a'], expected: [['a']] }, { name: '整串也是回文', args: ['efe'], expected: [['e','f','e'],['efe']] },
    ] },
  },
  {
    id: 135, slug: 'candy', title: '分发糖果', studyTags: ['贪心', '双向扫描', '相邻约束'],
    summary: '给每个孩子至少一颗糖，评分高于相邻孩子者必须拿到更多糖，求最少糖果总数。',
    insight: '从左到右满足相对左邻的约束，再从右到左用最大值补足相对右邻的约束。',
    pitfalls: ['两个方向的约束都必须满足', '相同评分不要求糖果更多', '第二遍应取 max 而不是覆盖'],
    solutions: [s('two-direction-greedy', '左右两遍贪心', '第一遍确定递增段需求，第二遍补齐从右侧看递增的需求。', ['糖果数组初始化为一', '左到右遇到评分上升则 candies[i]=candies[i-1]+1', '右到左按右邻约束取最大值并求和'], 'O(n)', 'O(n)',
      `class Solution {
    public int candy(int[] ratings) { int[] candies = new int[ratings.length]; Arrays.fill(candies, 1); for (int i = 1; i < ratings.length; i++) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; for (int i = ratings.length - 2; i >= 0; i--) if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], candies[i + 1] + 1); int total = 0; for (int value : candies) total += value; return total; }
}`,
      `class Solution {
    fun candy(ratings: IntArray): Int { val candies = IntArray(ratings.size) { 1 }; for (i in 1 until ratings.size) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; for (i in ratings.size - 2 downTo 0) if (ratings[i] > ratings[i + 1]) candies[i] = maxOf(candies[i], candies[i + 1] + 1); return candies.sum() }
}`,
      `class Solution {
public:
    int candy(vector<int>& ratings) { vector<int> candies(ratings.size(), 1); for (int i = 1; i < (int)ratings.size(); ++i) if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1; for (int i = ratings.size() - 2; i >= 0; --i) if (ratings[i] > ratings[i + 1]) candies[i] = max(candies[i], candies[i + 1] + 1); return accumulate(candies.begin(), candies.end(), 0); }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'candy', parameterTypes: ['intArray'], returnType: 'int', cases: [
      { name: '中间评分低', args: [[1,0,2]], expected: 5 }, { name: '相同评分无额外要求', args: [[1,2,2]], expected: 4 }, { name: '长上升后下降', args: [[1,3,4,5,2]], expected: 11 },
    ] },
  },
  {
    id: 137, slug: 'single-number-ii', title: '只出现一次的数字 II', studyTags: ['位运算', '有限状态机', '异或'],
    summary: '数组中除一个数出现一次外，其余数都恰好出现三次，在线性时间和常量空间内找出单独的数。',
    insight: '对每个二进制位维护出现次数模三的两位状态 ones 和 twos，第三次出现时两者都会清零。',
    pitfalls: ['负数同样按补码逐位处理', '更新 twos 时使用更新后的 ones', '不能使用额外哈希表才能满足空间要求'],
    solutions: [s('bit-state-machine', '位状态机模三计数', '并行处理所有二进制位，让状态在 00→01→10→00 间循环。', ['ones=(ones xor value) and not twos', 'twos=(twos xor value) and not ones', '所有数处理后 ones 即只出现一次的数'], 'O(n)', 'O(1)',
      `class Solution {
    public int singleNumber(int[] nums) { int ones = 0, twos = 0; for (int value : nums) { ones = (ones ^ value) & ~twos; twos = (twos ^ value) & ~ones; } return ones; }
}`,
      `class Solution {
    fun singleNumber(nums: IntArray): Int { var ones = 0; var twos = 0; for (value in nums) { ones = (ones xor value) and twos.inv(); twos = (twos xor value) and ones.inv() }; return ones }
}`,
      `class Solution {
public:
    int singleNumber(vector<int>& nums) { int ones = 0, twos = 0; for (int value : nums) { ones = (ones ^ value) & ~twos; twos = (twos ^ value) & ~ones; } return ones; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'singleNumber', parameterTypes: ['intArray'], returnType: 'int', cases: [
      { name: '单独数字在中间', args: [[2,2,3,2]], expected: 3 }, { name: '较大单独数字', args: [[0,1,0,1,0,1,99]], expected: 99 }, { name: '包含负数', args: [[-2,-2,-2,-7]], expected: -7 },
    ] },
  },
  {
    id: 144, slug: 'binary-tree-preorder-traversal', title: '二叉树的前序遍历', studyTags: ['二叉树', '迭代', '栈'],
    summary: '返回二叉树节点值的前序遍历序列，即依次访问根、左子树、右子树。',
    insight: '栈先压右孩子再压左孩子，后进先出的顺序会让左子树优先于右子树被访问。',
    pitfalls: ['空树返回空列表', '压栈顺序与访问顺序相反', '每个节点只入栈一次'],
    solutions: [s('iterative-stack', '显式栈前序遍历', '弹栈时记录节点，并按右后左的压栈顺序维持根左右访问。', ['根非空时入栈', '循环弹出并记录', '先压右孩子，再压左孩子'], 'O(n)', 'O(h)',
      `class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { List<Integer> answer = new ArrayList<>(); if (root == null) return answer; Deque<TreeNode> stack = new ArrayDeque<>(); stack.push(root); while (!stack.isEmpty()) { TreeNode node = stack.pop(); answer.add(node.val); if (node.right != null) stack.push(node.right); if (node.left != null) stack.push(node.left); } return answer; }
}`,
      `class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> { if (root == null) return emptyList(); val answer = mutableListOf<Int>(); val stack = ArrayDeque<TreeNode>(); stack.addLast(root); while (stack.isNotEmpty()) { val node = stack.removeLast(); answer.add(node.\`val\`); node.right?.let { stack.addLast(it) }; node.left?.let { stack.addLast(it) } }; return answer }
}`,
      `class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) { vector<int> answer; if (!root) return answer; stack<TreeNode*> nodes; nodes.push(root); while (!nodes.empty()) { TreeNode* node = nodes.top(); nodes.pop(); answer.push_back(node->val); if (node->right) nodes.push(node->right); if (node->left) nodes.push(node->left); } return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'preorderTraversal', parameterTypes: ['treeNode'], returnType: 'intList', cases: [
      { name: '含右子树的前序', args: [[1,null,2,3]], expected: [1,2,3] }, { name: '空树', args: [[]], expected: [] }, { name: '单节点', args: [[1]], expected: [1] },
    ] },
  },
  {
    id: 145, slug: 'binary-tree-postorder-traversal', title: '二叉树的后序遍历', studyTags: ['二叉树', '迭代', '栈'],
    summary: '返回二叉树节点值的后序遍历序列，即依次访问左子树、右子树、根。',
    insight: '用栈生成根、右、左顺序，最后整体反转即可得到左、右、根，避免记录节点访问状态。',
    pitfalls: ['压入左孩子后再压右孩子才能先处理右侧', '最终必须反转临时序列', '空树无需入栈'],
    solutions: [s('reverse-root-right-left', '根右左后反转', '把后序视为根右左序列的逆序，用一次反转完成。', ['根节点入栈', '弹出记录，并依次压左、右孩子', '遍历结束反转答案'], 'O(n)', 'O(h)',
      `class Solution {
    public List<Integer> postorderTraversal(TreeNode root) { LinkedList<Integer> answer = new LinkedList<>(); if (root == null) return answer; Deque<TreeNode> stack = new ArrayDeque<>(); stack.push(root); while (!stack.isEmpty()) { TreeNode node = stack.pop(); answer.addFirst(node.val); if (node.left != null) stack.push(node.left); if (node.right != null) stack.push(node.right); } return answer; }
}`,
      `class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> { if (root == null) return emptyList(); val answer = mutableListOf<Int>(); val stack = ArrayDeque<TreeNode>(); stack.addLast(root); while (stack.isNotEmpty()) { val node = stack.removeLast(); answer.add(node.\`val\`); node.left?.let { stack.addLast(it) }; node.right?.let { stack.addLast(it) } }; answer.reverse(); return answer }
}`,
      `class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) { vector<int> answer; if (!root) return answer; stack<TreeNode*> nodes; nodes.push(root); while (!nodes.empty()) { TreeNode* node = nodes.top(); nodes.pop(); answer.push_back(node->val); if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } reverse(answer.begin(), answer.end()); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'postorderTraversal', parameterTypes: ['treeNode'], returnType: 'intList', cases: [
      { name: '含右子树的后序', args: [[1,null,2,3]], expected: [3,2,1] }, { name: '空树', args: [[]], expected: [] }, { name: '单节点', args: [[1]], expected: [1] },
    ] },
  },
] }
