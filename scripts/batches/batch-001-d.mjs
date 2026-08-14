const makeSolution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({
  id,
  title,
  kind,
  idea,
  steps,
  complexity: { time, space },
  code: { java, kotlin, cpp },
})

export default {
  batchId: 'batch-001',
  problems: [
    {
      id: 98,
      slug: 'validate-binary-search-tree',
      title: '验证二叉搜索树',
      studyTags: ['上下界递归', '严格有序', '长整型边界'],
      summary: '判断一棵二叉树是否满足二叉搜索树性质：每个节点左子树的所有值更小，右子树的所有值更大。',
      insight: '节点不仅受父节点限制，还受到全部祖先传下来的开区间约束。',
      pitfalls: ['只比较节点与直接孩子并不充分', '相等值不满足严格二叉搜索树定义', '整数极值要求边界类型比节点值范围更宽'],
      solutions: [
        makeSolution(
          'recursive-bounds',
          '递归传递开区间',
          '最优',
          '为每个节点携带允许值的下界和上界，进入左右子树时分别收紧边界。',
          ['根节点从无限开区间开始', '节点值必须严格位于上下界之间', '左子树上界设为当前值，右子树下界设为当前值'],
          'O(n)',
          'O(h)',
          `class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }
}`,
          `class Solution {
    fun isValidBST(root: TreeNode?): Boolean = validate(root, Long.MIN_VALUE, Long.MAX_VALUE)

    private fun validate(node: TreeNode?, lower: Long, upper: Long): Boolean {
        node ?: return true
        val value = node.\`val\`.toLong()
        if (value <= lower || value >= upper) return false
        return validate(node.left, lower, value) && validate(node.right, value, upper)
    }
}`,
          `class Solution {
    bool validate(TreeNode* node, long long lower, long long upper) {
        if (!node) return true;
        if (node->val <= lower || node->val >= upper) return false;
        return validate(node->left, lower, node->val) && validate(node->right, node->val, upper);
    }
public:
    bool isValidBST(TreeNode* root) {
        return validate(root, LLONG_MIN, LLONG_MAX);
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'isValidBST',
        parameterTypes: ['treeNode'],
        returnType: 'boolean',
        cases: [
          { name: '三节点合法搜索树', args: [[2, 1, 3]], expected: true },
          { name: '右子树包含小于根的节点', args: [[5, 1, 4, null, null, 3, 6]], expected: false },
          { name: '重复值不满足严格顺序', args: [[2, 2, 2]], expected: false },
        ],
      },
    },
    {
      id: 101,
      slug: 'symmetric-tree',
      title: '对称二叉树',
      studyTags: ['镜像递归', '成对比较', '树结构'],
      summary: '判断一棵二叉树是否关于根节点的中心轴左右镜像对称。',
      insight: '对称性要求左树的外侧对应右树的外侧，同时左树内侧对应右树内侧。',
      pitfalls: ['节点值相等还不够，空节点位置也必须镜像', '递归比较的是 left.left 与 right.right', '空树可以视为对称'],
      solutions: [
        makeSolution(
          'mirror-recursion',
          '镜像节点递归',
          '最优',
          '同时递归两个应当互为镜像的节点，并交叉比较它们的孩子。',
          ['根为空时直接返回真', '一空一非空或值不同则失败', '递归比较外侧节点对和内侧节点对'],
          'O(n)',
          'O(h)',
          `class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        return left.val == right.val
            && mirror(left.left, right.right)
            && mirror(left.right, right.left);
    }
}`,
          `class Solution {
    fun isSymmetric(root: TreeNode?): Boolean = root == null || mirror(root.left, root.right)

    private fun mirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) return left === right
        return left.\`val\` == right.\`val\`
            && mirror(left.left, right.right)
            && mirror(left.right, right.left)
    }
}`,
          `class Solution {
    bool mirror(TreeNode* left, TreeNode* right) {
        if (!left || !right) return left == right;
        return left->val == right->val
            && mirror(left->left, right->right)
            && mirror(left->right, right->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        return !root || mirror(root->left, root->right);
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'isSymmetric',
        parameterTypes: ['treeNode'],
        returnType: 'boolean',
        cases: [
          { name: '完整镜像结构', args: [[1, 2, 2, 3, 4, 4, 3]], expected: true },
          { name: '空节点位置不对称', args: [[1, 2, 2, null, 3, null, 3]], expected: false },
          { name: '空树对称', args: [[]], expected: true },
        ],
      },
    },
    {
      id: 105,
      slug: 'construct-binary-tree-from-preorder-and-inorder-traversal',
      title: '从前序与中序遍历序列构造二叉树',
      studyTags: ['递归建树', '中序分割', '下标映射'],
      summary: '根据一棵无重复值二叉树的前序遍历和中序遍历序列，还原并返回这棵树。',
      insight: '前序序列按顺序提供每棵子树的根；根在中序序列中的位置则把左右子树区间准确分开。',
      pitfalls: ['前序下标应按根、左、右的递归顺序递增', '中序区间使用闭区间时边界要一致', '节点值互不重复才能建立唯一位置映射'],
      solutions: [
        makeSolution(
          'preorder-index-map',
          '前序指针 + 中序下标表',
          '最优',
          '哈希表保存每个值在中序序列的位置，用单调递增的前序指针依次创建根节点。',
          ['建立中序值到下标的映射', '读取当前前序值创建根节点', '按中序根位置递归构造左区间和右区间'],
          'O(n)',
          'O(n)',
          `class Solution {
    private int preorderIndex;
    private int[] preorder;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.preorderIndex = 0;
        this.inorderIndex = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) inorderIndex.put(inorder[index], index);
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);
        int middle = inorderIndex.get(value);
        root.left = build(left, middle - 1);
        root.right = build(middle + 1, right);
        return root;
    }
}`,
          `class Solution {
    private var preorderIndex = 0
    private lateinit var preorderValues: IntArray
    private lateinit var inorderIndex: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        preorderValues = preorder
        preorderIndex = 0
        inorderIndex = inorder.withIndex().associate { it.value to it.index }
        return build(0, inorder.lastIndex)
    }

    private fun build(left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val value = preorderValues[preorderIndex++]
        val root = TreeNode(value)
        val middle = inorderIndex.getValue(value)
        root.left = build(left, middle - 1)
        root.right = build(middle + 1, right)
        return root
    }
}`,
          `class Solution {
    int preorderIndex = 0;
    vector<int>* preorderValues = nullptr;
    unordered_map<int, int> inorderIndex;

    TreeNode* build(int left, int right) {
        if (left > right) return nullptr;
        int value = (*preorderValues)[preorderIndex++];
        TreeNode* root = new TreeNode(value);
        int middle = inorderIndex[value];
        root->left = build(left, middle - 1);
        root->right = build(middle + 1, right);
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        preorderValues = &preorder;
        preorderIndex = 0;
        inorderIndex.clear();
        for (int index = 0; index < (int)inorder.size(); ++index) inorderIndex[inorder[index]] = index;
        return build(0, (int)inorder.size() - 1);
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'buildTree',
        parameterTypes: ['intArray', 'intArray'],
        returnType: 'treeNode',
        cases: [
          { name: '同时包含左右子树', args: [[3, 9, 20, 15, 7], [9, 3, 15, 20, 7]], expected: [3, 9, 20, null, null, 15, 7] },
          { name: '单节点树', args: [[-1], [-1]], expected: [-1] },
          { name: '只有左孩子', args: [[1, 2], [2, 1]], expected: [1, 2] },
        ],
      },
    },
    {
      id: 128,
      slug: 'longest-consecutive-sequence',
      title: '最长连续序列',
      studyTags: ['哈希集合', '序列起点', '避免重复扫描'],
      summary: '在未排序整数数组中，求数值连续递增一的最长序列长度，要求整体线性时间。',
      insight: '只有当 x-1 不在集合中时，x 才是某条连续序列的起点；从起点向后扫描不会重复覆盖其他序列。',
      pitfalls: ['连续序列按数值而不是原数组位置定义', '重复元素不应增加长度', '从每个元素都双向扩展会退化为平方时间'],
      solutions: [
        makeSolution(
          'hash-sequence-start',
          '哈希集合识别起点',
          '最优',
          '把所有值放入集合，只从没有前驱的值开始统计连续长度。',
          ['建立去重哈希集合', '跳过存在 value - 1 的非起点', '从起点递增查找并更新最长长度'],
          'O(n)',
          'O(n)',
          `class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for (int value : nums) values.add(value);
        int best = 0;
        for (int value : values) {
            if (values.contains(value - 1)) continue;
            int length = 1;
            while (values.contains(value + length)) length++;
            best = Math.max(best, length);
        }
        return best;
    }
}`,
          `class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val values = nums.toHashSet()
        var best = 0
        for (value in values) {
            if (value - 1 in values) continue
            var length = 1
            while (value + length in values) length++
            best = maxOf(best, length)
        }
        return best
    }
}`,
          `class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> values(nums.begin(), nums.end());
        int best = 0;
        for (int value : values) {
            if (values.count(value - 1)) continue;
            int length = 1;
            while (values.count(value + length)) ++length;
            best = max(best, length);
        }
        return best;
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'longestConsecutive',
        parameterTypes: ['intArray'],
        returnType: 'int',
        cases: [
          { name: '乱序数组包含四个连续值', args: [[100, 4, 200, 1, 3, 2]], expected: 4 },
          { name: '重复元素不增加长度', args: [[0, 3, 7, 2, 5, 8, 4, 6, 0, 1]], expected: 9 },
          { name: '空数组', args: [[]], expected: 0 },
        ],
      },
    },
    {
      id: 139,
      slug: 'word-break',
      title: '单词拆分',
      studyTags: ['前缀动态规划', '字符串切分', '字典集合'],
      summary: '判断字符串能否被拆分成一个或多个字典中的单词，字典单词可以重复使用。',
      insight: '令 dp[i] 表示长度为 i 的前缀能否拆分；只要存在可拆分前缀 j 且 s[j..i) 在字典中，dp[i] 就成立。',
      pitfalls: ['单词允许重复使用', '状态下标表示前缀长度而不是字符下标', '只有 dp[start] 为真时才需要检查后续子串'],
      solutions: [
        makeSolution(
          'prefix-dp',
          '前缀可达动态规划',
          '最优',
          '从每个已经可拆分的前缀出发，检查它与后续位置组成的单词是否在字典中。',
          ['把字典转换为哈希集合', '初始化空前缀 dp[0] 为真', '枚举结尾和切分点更新 dp[end]'],
          'O(n³)',
          'O(n + |dict|)',
          `class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] possible = new boolean[s.length() + 1];
        possible[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (possible[start] && words.contains(s.substring(start, end))) {
                    possible[end] = true;
                    break;
                }
            }
        }
        return possible[s.length()];
    }
}`,
          `class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val words = wordDict.toHashSet()
        val possible = BooleanArray(s.length + 1)
        possible[0] = true
        for (end in 1..s.length) {
            for (start in 0 until end) {
                if (possible[start] && s.substring(start, end) in words) {
                    possible[end] = true
                    break
                }
            }
        }
        return possible[s.length]
    }
}`,
          `class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> words(wordDict.begin(), wordDict.end());
        vector<bool> possible(s.size() + 1);
        possible[0] = true;
        for (int end = 1; end <= (int)s.size(); ++end) {
            for (int start = 0; start < end; ++start) {
                if (possible[start] && words.count(s.substr(start, end - start))) {
                    possible[end] = true;
                    break;
                }
            }
        }
        return possible[s.size()];
    }
};`,
        ),
      ],
      tests: {
        schemaVersion: 1,
        mode: 'function',
        method: 'wordBreak',
        parameterTypes: ['string', 'stringList'],
        returnType: 'boolean',
        cases: [
          { name: '拆成两个不同单词', args: ['leetcode', ['leet', 'code']], expected: true },
          { name: '重复使用同一单词', args: ['applepenapple', ['apple', 'pen']], expected: true },
          { name: '局部可拆但整体失败', args: ['catsandog', ['cats', 'dog', 'sand', 'and', 'cat']], expected: false },
        ],
      },
    },
  ],
}
