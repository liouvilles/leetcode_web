const s = (id, title, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind: '最优', idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })
export default { batchId: 'batch-004', problems: [
  {
    id: 106, slug: 'construct-binary-tree-from-inorder-and-postorder-traversal', title: '从中序与后序遍历序列构造二叉树', studyTags: ['二叉树', '递归分治', '哈希索引'],
    summary: '根据无重复节点值的中序遍历和后序遍历数组，还原唯一的二叉树。',
    insight: '后序数组从末尾取根；由于消费顺序是根、右、左，递归时必须先构建右子树，再构建左子树。',
    pitfalls: ['中序位置决定左右子树边界', '后序下标应全局递减', '递归构建顺序不能写反'],
    solutions: [s('reverse-postorder-recursion', '逆后序递归分治', '预存中序下标，按后序的根右左逆序消费节点。', ['建立 value 到 inorder 下标的映射', '取 postorder[postIndex--] 为根', '先递归右区间，再递归左区间'], 'O(n)', 'O(n)',
      `class Solution {
    private int postIndex; private Map<Integer, Integer> positions;
    public TreeNode buildTree(int[] inorder, int[] postorder) { positions = new HashMap<>(); for (int index = 0; index < inorder.length; index++) positions.put(inorder[index], index); postIndex = postorder.length - 1; return build(0, inorder.length - 1, postorder); }
    private TreeNode build(int left, int right, int[] postorder) { if (left > right) return null; int value = postorder[postIndex--], middle = positions.get(value); TreeNode root = new TreeNode(value); root.right = build(middle + 1, right, postorder); root.left = build(left, middle - 1, postorder); return root; }
}`,
      `class Solution {
    private var postIndex = 0; private lateinit var positions: Map<Int, Int>
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? { positions = inorder.withIndex().associate { it.value to it.index }; postIndex = postorder.lastIndex; fun build(left: Int, right: Int): TreeNode? { if (left > right) return null; val value = postorder[postIndex--]; val middle = positions[value]!!; val root = TreeNode(value); root.right = build(middle + 1, right); root.left = build(left, middle - 1); return root }; return build(0, inorder.lastIndex) }
}`,
      `class Solution {
    int postIndex; unordered_map<int, int> positions;
    TreeNode* build(int left, int right, vector<int>& postorder) { if (left > right) return nullptr; int value = postorder[postIndex--], middle = positions[value]; TreeNode* root = new TreeNode(value); root->right = build(middle + 1, right, postorder); root->left = build(left, middle - 1, postorder); return root; }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) { for (int index = 0; index < (int)inorder.size(); ++index) positions[inorder[index]] = index; postIndex = postorder.size() - 1; return build(0, inorder.size() - 1, postorder); }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'buildTree', parameterTypes: ['intArray','intArray'], returnType: 'treeNode', cases: [
      { name: '还原左右子树', args: [[9,3,15,20,7],[9,15,7,20,3]], expected: [3,9,20,null,null,15,7] }, { name: '单节点树', args: [[-1],[-1]], expected: [-1] }, { name: '只有左子树', args: [[2,1],[2,1]], expected: [1,2] },
    ] },
  },
  {
    id: 108, slug: 'convert-sorted-array-to-binary-search-tree', title: '将有序数组转换为二叉搜索树', studyTags: ['二叉搜索树', '递归分治', '平衡树'],
    summary: '把严格递增数组转换为一棵高度平衡的二叉搜索树。',
    insight: '每次选择区间中点作为根，左右半区分别递归建树，子树规模之差自然不超过一。',
    pitfalls: ['空区间返回空节点', '中点选上中位或下中位都可', '结果需同时满足 BST 与高度平衡'],
    solutions: [s('middle-as-root', '中点递归建树', '把数组中点作为根，并对左右子区间重复相同过程。', ['递归接收闭区间 left/right', '选 middle 并创建根', '左右区间分别构造子树'], 'O(n)', 'O(log n)',
      `class Solution {
    public TreeNode sortedArrayToBST(int[] nums) { return build(nums, 0, nums.length - 1); }
    private TreeNode build(int[] nums, int left, int right) { if (left > right) return null; int middle = left + (right - left) / 2; TreeNode root = new TreeNode(nums[middle]); root.left = build(nums, left, middle - 1); root.right = build(nums, middle + 1, right); return root; }
}`,
      `class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? { fun build(left: Int, right: Int): TreeNode? { if (left > right) return null; val middle = left + (right - left) / 2; val root = TreeNode(nums[middle]); root.left = build(left, middle - 1); root.right = build(middle + 1, right); return root }; return build(0, nums.lastIndex) }
}`,
      `class Solution {
    TreeNode* build(vector<int>& nums, int left, int right) { if (left > right) return nullptr; int middle = left + (right - left) / 2; TreeNode* root = new TreeNode(nums[middle]); root->left = build(nums, left, middle - 1); root->right = build(nums, middle + 1, right); return root; }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) { return build(nums, 0, nums.size() - 1); }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'sortedArrayToBST', parameterTypes: ['intArray'], returnType: 'treeNode', cases: [
      { name: '奇数长度数组', args: [[-10,-3,0,5,9]], expected: [0,-10,5,null,-3,null,9] }, { name: '偶数长度取下中位', args: [[1,3]], expected: [1,null,3] }, { name: '空数组', args: [[]], expected: [] },
    ] },
  },
  {
    id: 111, slug: 'minimum-depth-of-binary-tree', title: '二叉树的最小深度', studyTags: ['二叉树', '广度优先搜索', '最短路径'],
    summary: '返回从根节点到最近叶子节点的节点数量，空树的最小深度为零。',
    insight: '层序遍历第一次遇到叶子时，该节点所在层就是最小深度，可以立即结束搜索。',
    pitfalls: ['叶子必须同时没有左右孩子', '只有一个孩子的节点不能把空侧当作路径', '空树返回零'],
    solutions: [s('bfs-first-leaf', '层序搜索首个叶子', '按深度逐层扩展，遇到的第一个叶子必然离根最近。', ['根为空返回零', '队列逐层处理并增加 depth', '节点无左右孩子时返回当前深度'], 'O(n)', 'O(w)',
      `class Solution {
    public int minDepth(TreeNode root) { if (root == null) return 0; Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root); int depth = 0; while (!queue.isEmpty()) { depth++; for (int size = queue.size(); size > 0; size--) { TreeNode node = queue.poll(); if (node.left == null && node.right == null) return depth; if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } } return depth; }
}`,
      `class Solution {
    fun minDepth(root: TreeNode?): Int { if (root == null) return 0; val queue = ArrayDeque<TreeNode>(); queue.add(root); var depth = 0; while (queue.isNotEmpty()) { depth++; repeat(queue.size) { val node = queue.removeFirst(); if (node.left == null && node.right == null) return depth; node.left?.let { queue.add(it) }; node.right?.let { queue.add(it) } } }; return depth }
}`,
      `class Solution {
public:
    int minDepth(TreeNode* root) { if (!root) return 0; queue<TreeNode*> nodes; nodes.push(root); int depth = 0; while (!nodes.empty()) { ++depth; for (int size = nodes.size(); size > 0; --size) { TreeNode* node = nodes.front(); nodes.pop(); if (!node->left && !node->right) return depth; if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } } return depth; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'minDepth', parameterTypes: ['treeNode'], returnType: 'int', cases: [
      { name: '最近叶子在第二层', args: [[3,9,20,null,null,15,7]], expected: 2 }, { name: '右侧单链', args: [[2,null,3,null,4,null,5,null,6]], expected: 5 }, { name: '空树', args: [[]], expected: 0 },
    ] },
  },
  {
    id: 113, slug: 'path-sum-ii', title: '路径总和 II', studyTags: ['二叉树', '深度优先搜索', '回溯'],
    summary: '返回二叉树中所有从根到叶子且节点值总和等于目标值的路径。',
    insight: '深度优先维护当前路径和剩余目标；只有到达叶子且剩余值恰好等于叶子值时才记录。',
    pitfalls: ['路径必须结束于叶子', '节点值可能为负', '回到父节点前要撤销当前节点'],
    solutions: [s('dfs-backtracking', '根到叶回溯', '沿每条根到叶路径递减目标值，命中时复制路径。', ['当前节点加入路径', '叶子且值等于 remaining 时记录', '递归左右子树后移除当前节点'], 'O(n)', 'O(h)',
      `class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) { List<List<Integer>> answer = new ArrayList<>(); dfs(root, targetSum, new ArrayList<>(), answer); return answer; }
    private void dfs(TreeNode node, long remaining, List<Integer> path, List<List<Integer>> answer) { if (node == null) return; path.add(node.val); if (node.left == null && node.right == null && remaining == node.val) answer.add(new ArrayList<>(path)); else { dfs(node.left, remaining - node.val, path, answer); dfs(node.right, remaining - node.val, path, answer); } path.remove(path.size() - 1); }
}`,
      `class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> { val answer = mutableListOf<List<Int>>(); val path = mutableListOf<Int>(); fun dfs(node: TreeNode?, remaining: Long) { if (node == null) return; path.add(node.\`val\`); if (node.left == null && node.right == null && remaining == node.\`val\`.toLong()) answer.add(path.toList()) else { dfs(node.left, remaining - node.\`val\`); dfs(node.right, remaining - node.\`val\`) }; path.removeAt(path.lastIndex) }; dfs(root, targetSum.toLong()); return answer }
}`,
      `class Solution {
    void dfs(TreeNode* node, long long remaining, vector<int>& path, vector<vector<int>>& answer) { if (!node) return; path.push_back(node->val); if (!node->left && !node->right && remaining == node->val) answer.push_back(path); else { dfs(node->left, remaining - node->val, path, answer); dfs(node->right, remaining - node->val, path, answer); } path.pop_back(); }
public:
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) { vector<vector<int>> answer; vector<int> path; dfs(root, targetSum, path, answer); return answer; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'pathSum', parameterTypes: ['treeNode','int'], returnType: 'intListMatrix', cases: [
      { name: '两条目标路径', args: [[5,4,8,11,null,13,4,7,2,null,null,5,1],22], expected: [[5,4,11,2],[5,8,4,5]] }, { name: '无目标路径', args: [[1,2,3],5], expected: [] }, { name: '单条目标路径', args: [[1,2],3], expected: [[1,2]] },
    ] },
  },
  {
    id: 114, slug: 'flatten-binary-tree-to-linked-list', title: '二叉树展开为链表', studyTags: ['二叉树', '逆前序遍历', '原地修改'],
    summary: '把二叉树原地展开成只使用右指针的链表，节点顺序与原树前序遍历一致。',
    insight: '按右、左、根的逆前序递归，维护已展开部分的头节点；当前节点右指向它、左置空即可。',
    pitfalls: ['结果中所有左指针都必须为空', '递归顺序必须先右后左', '不能新建替代节点'],
    solutions: [s('reverse-preorder', '逆前序递归串联', '从前序的末尾向前构造右链，previous 始终指向当前节点的后继。', ['先递归右子树', '再递归左子树', '当前 right=previous、left=null，并更新 previous'], 'O(n)', 'O(h)',
      `class Solution {
    private TreeNode previous;
    public void flatten(TreeNode root) { if (root == null) return; flatten(root.right); flatten(root.left); root.right = previous; root.left = null; previous = root; }
}`,
      `class Solution {
    private var previous: TreeNode? = null
    fun flatten(root: TreeNode?) { if (root == null) return; flatten(root.right); flatten(root.left); root.right = previous; root.left = null; previous = root }
}`,
      `class Solution {
    TreeNode* previous = nullptr;
public:
    void flatten(TreeNode* root) { if (!root) return; flatten(root->right); flatten(root->left); root->right = previous; root->left = nullptr; previous = root; }
};`)],
    tests: { schemaVersion: 1, mode: 'function', method: 'flatten', parameterTypes: ['treeNode'], returnType: 'void', cases: [
      { name: '展开多层二叉树', args: [[1,2,5,3,4,null,6]], expectedArgs: [{ index: 0, type: 'treeNode', expected: [1,null,2,null,3,null,4,null,5,null,6] }] },
      { name: '单节点', args: [[0]], expectedArgs: [{ index: 0, type: 'treeNode', expected: [0] }] },
      { name: '空树', args: [[]], expectedArgs: [{ index: 0, type: 'treeNode', expected: [] }] },
    ] },
  },
] }
