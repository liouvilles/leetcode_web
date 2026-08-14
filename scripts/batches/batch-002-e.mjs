const solution = (id, title, kind, idea, steps, time, space, java, kotlin, cpp) => ({ id, title, kind, idea, steps, complexity: { time, space }, code: { java, kotlin, cpp } })

export default {
  batchId: 'batch-002',
  problems: [
    {
      id: 100, slug: 'same-tree', title: '相同的树',
      studyTags: ['同步递归', '结构比较', '二叉树'],
      summary: '判断两棵二叉树在结构和每个对应节点的值上是否完全相同。',
      insight: '同步检查两个当前位置：同时为空相同，一空一非空或值不同则失败，其余递归比较左右孩子。',
      pitfalls: ['仅遍历节点值会遗漏结构差异', '两个空节点应返回真', '左右子树必须按相同方向对应'],
      solutions: [solution('synchronous-recursion', '同步递归比较', '最优', '每次递归处理一对对应节点并组合左右子树结果。', ['同时为空返回真', '空状态或值不同返回假', '递归比较左对左、右对右'], 'O(n)', 'O(h)',
        `class Solution {
    public boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null || second == null) return first == second;
        return first.val == second.val && isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }
}`,
        `class Solution {
    fun isSameTree(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null || second == null) return first === second
        return first.\`val\` == second.\`val\` && isSameTree(first.left, second.left) && isSameTree(first.right, second.right)
    }
}`,
        `class Solution {
public:
    bool isSameTree(TreeNode* first, TreeNode* second) {
        if (!first || !second) return first == second;
        return first->val == second->val && isSameTree(first->left, second->left) && isSameTree(first->right, second->right);
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isSameTree', parameterTypes: ['treeNode', 'treeNode'], returnType: 'boolean', cases: [
        { name: '结构和值完全相同', args: [[1, 2, 3], [1, 2, 3]], expected: true },
        { name: '孩子方向不同', args: [[1, 2], [1, null, 2]], expected: false },
        { name: '节点值不同', args: [[1, 2, 1], [1, 1, 2]], expected: false },
      ] },
    },
    {
      id: 110, slug: 'balanced-binary-tree', title: '平衡二叉树',
      studyTags: ['后序遍历', '高度剪枝', '哨兵返回值'],
      summary: '判断一棵二叉树是否满足每个节点左右子树高度差不超过一。',
      insight: '后序计算高度时用 -1 表示子树已经不平衡，可以立即向上传播并停止无用计算。',
      pitfalls: ['平衡条件必须对每个节点成立', '重复单独计算高度会退化为平方时间', '空树高度可定义为零'],
      solutions: [solution('height-or-failure', '高度与失败合并返回', '最优', '一次后序遍历同时完成高度计算和平衡性判断。', ['递归得到左右子树高度', '任一返回 -1 或高度差超过一就返回 -1', '否则返回较大高度加一'], 'O(n)', 'O(h)',
        `class Solution {
    public boolean isBalanced(TreeNode root) { return height(root) >= 0; }
    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left); if (left < 0) return -1;
        int right = height(node.right); if (right < 0 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}`,
        `class Solution {
    fun isBalanced(root: TreeNode?): Boolean = height(root) >= 0
    private fun height(node: TreeNode?): Int {
        node ?: return 0
        val left = height(node.left); if (left < 0) return -1
        val right = height(node.right); if (right < 0 || kotlin.math.abs(left - right) > 1) return -1
        return maxOf(left, right) + 1
    }
}`,
        `class Solution {
    int height(TreeNode* node) {
        if (!node) return 0;
        int left = height(node->left); if (left < 0) return -1;
        int right = height(node->right); if (right < 0 || abs(left - right) > 1) return -1;
        return max(left, right) + 1;
    }
public:
    bool isBalanced(TreeNode* root) { return height(root) >= 0; }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isBalanced', parameterTypes: ['treeNode'], returnType: 'boolean', cases: [
        { name: '普通平衡树', args: [[3, 9, 20, null, null, 15, 7]], expected: true },
        { name: '左侧高度差过大', args: [[1, 2, 2, 3, 3, null, null, 4, 4]], expected: false },
        { name: '空树平衡', args: [[]], expected: true },
      ] },
    },
    {
      id: 112, slug: 'path-sum', title: '路径总和',
      studyTags: ['深度优先搜索', '剩余目标', '根到叶路径'],
      summary: '判断二叉树中是否存在一条从根节点到叶节点的路径，其节点值之和等于目标值。',
      insight: '沿路径递归扣除当前节点值，到达叶节点时检查剩余目标是否正好等于叶节点值。',
      pitfalls: ['路径必须在叶节点结束', '不能把任意中间节点当作终点', '节点值和目标都可能为负数'],
      solutions: [solution('remaining-sum-dfs', '剩余目标 DFS', '最优', '递归把问题缩小为子树中是否存在和为 target-current 的根到叶路径。', ['空节点返回假', '叶节点直接比较当前值和剩余目标', '对左右子树递归并取或'], 'O(n)', 'O(h)',
        `class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}`,
        `class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null) return root.\`val\` == targetSum
        val remaining = targetSum - root.\`val\`
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)
    }
}`,
        `class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (!root) return false;
        if (!root->left && !root->right) return root->val == targetSum;
        int remaining = targetSum - root->val;
        return hasPathSum(root->left, remaining) || hasPathSum(root->right, remaining);
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'hasPathSum', parameterTypes: ['treeNode', 'int'], returnType: 'boolean', cases: [
        { name: '存在根到叶目标路径', args: [[5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1], 22], expected: true },
        { name: '相同前缀但叶节点不满足', args: [[1, 2, 3], 5], expected: false },
        { name: '空树没有路径', args: [[], 0], expected: false },
      ] },
    },
    {
      id: 125, slug: 'valid-palindrome', title: '验证回文串',
      studyTags: ['双指针', '字符过滤', '忽略大小写'],
      summary: '忽略非字母数字字符和字母大小写后，判断字符串是否为回文。',
      insight: '左右指针跳过无关字符，仅比较下一对有效字符的小写形式即可，无需构造新字符串。',
      pitfalls: ['数字也属于有效字符', '比较前需要统一大小写', '全由标点组成的字符串视为空回文串'],
      solutions: [solution('filtered-two-pointers', '过滤式双指针', '最优', '从两端向中间移动，按需跳过非字母数字字符。', ['左指针跳到下一个有效字符', '右指针跳到上一个有效字符', '比较忽略大小写后的字符并继续收缩'], 'O(n)', 'O(1)',
        `class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) return false;
        }
        return true;
    }
}`,
        `class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0; var right = s.lastIndex
        while (left < right) {
            while (left < right && !s[left].isLetterOrDigit()) left++
            while (left < right && !s[right].isLetterOrDigit()) right--
            if (s[left++].lowercaseChar() != s[right--].lowercaseChar()) return false
        }
        return true
    }
}`,
        `class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0, right = s.size() - 1;
        while (left < right) {
            while (left < right && !isalnum((unsigned char)s[left])) ++left;
            while (left < right && !isalnum((unsigned char)s[right])) --right;
            if (tolower((unsigned char)s[left++]) != tolower((unsigned char)s[right--])) return false;
        }
        return true;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'isPalindrome', parameterTypes: ['string'], returnType: 'boolean', cases: [
        { name: '忽略标点和大小写后回文', args: ['A man, a plan, a canal: Panama'], expected: true },
        { name: '有效字符顺序不回文', args: ['race a car'], expected: false },
        { name: '只有空格', args: [' '], expected: true },
      ] },
    },
    {
      id: 136, slug: 'single-number', title: '只出现一次的数字',
      studyTags: ['异或', '成对抵消', '常数空间'],
      summary: '数组中除一个元素只出现一次外，其余元素都恰好出现两次，找出这个单独元素。',
      insight: '异或满足相同数抵消为零且顺序无关，把所有元素异或后只剩单独值。',
      pitfalls: ['不能依赖排序或额外集合才能达到目标空间复杂度', '负数按位异或同样成立', '初始结果应为零'],
      solutions: [solution('xor-cancellation', '全数组异或抵消', '最优', '利用 x xor x = 0 和 x xor 0 = x 消除所有成对元素。', ['结果初始化为零', '依次与每个元素异或', '返回最终剩余值'], 'O(n)', 'O(1)',
        `class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for (int value : nums) answer ^= value;
        return answer;
    }
}`,
        `class Solution {
    fun singleNumber(nums: IntArray): Int {
        var answer = 0
        for (value in nums) answer = answer xor value
        return answer
    }
}`,
        `class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int answer = 0;
        for (int value : nums) answer ^= value;
        return answer;
    }
};`)],
      tests: { schemaVersion: 1, mode: 'function', method: 'singleNumber', parameterTypes: ['intArray'], returnType: 'int', cases: [
        { name: '一个成对元素', args: [[2, 2, 1]], expected: 1 },
        { name: '多组成对元素', args: [[4, 1, 2, 1, 2]], expected: 4 },
        { name: '单元素数组', args: [[1]], expected: 1 },
      ] },
    },
  ],
}
