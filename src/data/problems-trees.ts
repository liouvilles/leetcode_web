import type { Problem } from '../types'

export const treeProblems: Problem[] = [
  {
    id: 94,
    slug: 'binary-tree-inorder-traversal',
    title: '二叉树的中序遍历',
    titleEn: 'Binary Tree Inorder Traversal',
    difficulty: '简单',
    category: '二叉树',
    officialTags: ['栈', '树', '深度优先搜索', '二叉树'],
    studyTags: ['左根右', '显式栈', 'Morris'],
    summary: '按“左子树、根结点、右子树”的顺序返回二叉树所有结点值。',
    insight: '递归调用栈和显式栈本质相同；Morris 则把空闲的右指针临时改造成返回路径。',
    pitfalls: ['访问根结点的时机在左子树之后', '迭代时外层条件要包含栈非空', 'Morris 结束前必须恢复树结构'],
    sourceUrl: 'https://leetcode.cn/problems/binary-tree-inorder-traversal/',
    solutions: [
      {
        id: 'recursive',
        title: '递归 DFS',
        kind: '基础',
        idea: '严格按照左、根、右的顺序递归访问并写入结果。',
        steps: ['递归访问左子树', '记录当前结点', '递归访问右子树'],
        complexity: { time: 'O(n)', space: 'O(h)' },
        code: {
          java: `class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node == null) return;
        dfs(node.left, result);
        result.add(node.val);
        dfs(node.right, result);
    }
}`,
          kotlin: `class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) return
            dfs(node.left)
            result.add(node.\`val\`)
            dfs(node.right)
        }
        dfs(root)
        return result
    }
}`,
          cpp: `class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        dfs(root, result);
        return result;
    }

private:
    void dfs(TreeNode* node, vector<int>& result) {
        if (!node) return;
        dfs(node->left, result);
        result.push_back(node->val);
        dfs(node->right, result);
    }
};`,
        },
      },
      {
        id: 'iterative-stack',
        title: '显式栈迭代',
        kind: '进阶',
        idea: '不断把左链压栈，栈顶就是下一个应访问的结点。',
        steps: ['沿左指针压入所有结点', '弹出栈顶并记录', '转向它的右子树重复过程'],
        complexity: { time: 'O(n)', space: 'O(h)' },
        code: {
          java: `class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}`,
          kotlin: `class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = java.util.ArrayDeque<TreeNode>()
        var current = root
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            current = stack.pop()
            result.add(current.\`val\`)
            current = current.right
        }
        return result
    }
}`,
          cpp: `class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodes;
        TreeNode* current = root;
        while (current || !nodes.empty()) {
            while (current) {
                nodes.push(current);
                current = current->left;
            }
            current = nodes.top(); nodes.pop();
            result.push_back(current->val);
            current = current->right;
        }
        return result;
    }
};`,
        },
      },
      {
        id: 'morris',
        title: 'Morris 线索遍历',
        kind: '最优',
        idea: '利用左子树最右结点的空 right 指针建立临时返回路径，实现常数额外空间。',
        steps: ['无左子树时直接访问并向右', '首次找到前驱时建立前驱到当前结点的线索', '再次遇到线索时恢复 null、访问当前结点并向右'],
        complexity: { time: 'O(n)', space: 'O(1)' },
        code: {
          java: `class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                result.add(current.val);
                current = current.right;
            } else {
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    result.add(current.val);
                    current = current.right;
                }
            }
        }
        return result;
    }
}`,
          kotlin: `class Solution {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        var current = root
        while (current != null) {
            if (current.left == null) {
                result.add(current.\`val\`)
                current = current.right
            } else {
                var predecessor = current.left!!
                while (predecessor.right != null && predecessor.right !== current) {
                    predecessor = predecessor.right!!
                }
                if (predecessor.right == null) {
                    predecessor.right = current
                    current = current.left
                } else {
                    predecessor.right = null
                    result.add(current.\`val\`)
                    current = current.right
                }
            }
        }
        return result
    }
}`,
          cpp: `class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> result;
        TreeNode* current = root;
        while (current) {
            if (!current->left) {
                result.push_back(current->val);
                current = current->right;
            } else {
                TreeNode* predecessor = current->left;
                while (predecessor->right && predecessor->right != current)
                    predecessor = predecessor->right;
                if (!predecessor->right) {
                    predecessor->right = current;
                    current = current->left;
                } else {
                    predecessor->right = nullptr;
                    result.push_back(current->val);
                    current = current->right;
                }
            }
        }
        return result;
    }
};`,
        },
      },
    ],
  },
  {
    id: 102,
    slug: 'binary-tree-level-order-traversal',
    title: '二叉树的层序遍历',
    titleEn: 'Binary Tree Level Order Traversal',
    difficulty: '中等',
    category: '二叉树',
    officialTags: ['树', '广度优先搜索', '二叉树'],
    studyTags: ['分层 BFS', '队列快照', '深度分组'],
    summary: '从根结点开始逐层、从左到右收集二叉树的结点值。',
    insight: '每轮开始时队列的长度，恰好是当前层尚未处理的结点数。',
    pitfalls: ['空树返回空列表', '必须在处理本层前固定 size', 'DFS 版本要在首次抵达某深度时建组'],
    sourceUrl: 'https://leetcode.cn/problems/binary-tree-level-order-traversal/',
    solutions: [
      {
        id: 'bfs',
        title: '队列分层 BFS',
        kind: '最优',
        idea: '队列保存下一批待访问结点，用每轮的固定队列长度划分层级。',
        steps: ['根结点入队', '记录当前队列长度并处理恰好这么多个结点', '把子结点入队并保存本层结果'],
        complexity: { time: 'O(n)', space: 'O(w)' },
        code: {
          java: `class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}`,
          kotlin: `class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()
        val result = mutableListOf<List<Int>>()
        val queue = java.util.ArrayDeque<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            repeat(queue.size) {
                val node = queue.poll()
                level.add(node.\`val\`)
                node.left?.let(queue::offer)
                node.right?.let(queue::offer)
            }
            result.add(level)
        }
        return result
    }
}`,
          cpp: `class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (!root) return {};
        vector<vector<int>> result;
        queue<TreeNode*> nodes;
        nodes.push(root);
        while (!nodes.empty()) {
            int size = nodes.size();
            vector<int> level;
            while (size--) {
                TreeNode* node = nodes.front(); nodes.pop();
                level.push_back(node->val);
                if (node->left) nodes.push(node->left);
                if (node->right) nodes.push(node->right);
            }
            result.push_back(move(level));
        }
        return result;
    }
};`,
        },
      },
      {
        id: 'dfs-by-depth',
        title: '按深度分组 DFS',
        kind: '进阶',
        idea: '深度优先访问时携带 depth，把同一深度的结点追加到同一个列表。',
        steps: ['首次到达 depth 时创建列表', '把当前值加入 result[depth]', '依次递归左右子树并令深度加一'],
        complexity: { time: 'O(n)', space: 'O(h)' },
        code: {
          java: `class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> result) {
        if (node == null) return;
        if (depth == result.size()) result.add(new ArrayList<>());
        result.get(depth).add(node.val);
        dfs(node.left, depth + 1, result);
        dfs(node.right, depth + 1, result);
    }
}`,
          kotlin: `class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        fun dfs(node: TreeNode?, depth: Int) {
            if (node == null) return
            if (depth == result.size) result.add(mutableListOf())
            result[depth].add(node.\`val\`)
            dfs(node.left, depth + 1)
            dfs(node.right, depth + 1)
        }
        dfs(root, 0)
        return result
    }
}`,
          cpp: `class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        dfs(root, 0, result);
        return result;
    }

private:
    void dfs(TreeNode* node, int depth, vector<vector<int>>& result) {
        if (!node) return;
        if (depth == (int)result.size()) result.push_back({});
        result[depth].push_back(node->val);
        dfs(node->left, depth + 1, result);
        dfs(node->right, depth + 1, result);
    }
};`,
        },
      },
    ],
  },
  {
    id: 104,
    slug: 'maximum-depth-of-binary-tree',
    title: '二叉树的最大深度',
    titleEn: 'Maximum Depth of Binary Tree',
    difficulty: '简单',
    category: '二叉树',
    officialTags: ['树', '深度优先搜索', '广度优先搜索', '二叉树'],
    studyTags: ['树高', '后序递归', '分层计数'],
    summary: '求从根结点到最远叶子结点的最长路径所包含的结点数。',
    insight: '一棵非空树的高度等于左右子树较大高度加一。',
    pitfalls: ['空树深度为 0', '题目计算结点数而不是边数', '极端链状树会产生 O(n) 递归深度'],
    sourceUrl: 'https://leetcode.cn/problems/maximum-depth-of-binary-tree/',
    solutions: [
      {
        id: 'recursive-dfs',
        title: '递归求树高',
        kind: '最优',
        idea: '递归获得左右子树高度，当前结点高度取较大者加一。',
        steps: ['空结点返回 0', '递归计算左右高度', '返回 max(left, right) + 1'],
        complexity: { time: 'O(n)', space: 'O(h)' },
        code: {
          java: `class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}`,
          kotlin: `class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}`,
          cpp: `class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};`,
        },
      },
      {
        id: 'level-bfs',
        title: '层序遍历计数',
        kind: '进阶',
        idea: '每完成一层 BFS 就把深度加一，最后处理的层就是最深层。',
        steps: ['根结点入队', '按当前队列长度消费一整层', '加入子结点并递增深度'],
        complexity: { time: 'O(n)', space: 'O(w)' },
        code: {
          java: `class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}`,
          kotlin: `class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val queue = java.util.ArrayDeque<TreeNode>()
        queue.offer(root)
        var depth = 0
        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val node = queue.poll()
                node.left?.let(queue::offer)
                node.right?.let(queue::offer)
            }
            depth++
        }
        return depth
    }
}`,
          cpp: `class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        queue<TreeNode*> nodes;
        nodes.push(root);
        int depth = 0;
        while (!nodes.empty()) {
            for (int size = nodes.size(); size > 0; --size) {
                TreeNode* node = nodes.front(); nodes.pop();
                if (node->left) nodes.push(node->left);
                if (node->right) nodes.push(node->right);
            }
            ++depth;
        }
        return depth;
    }
};`,
        },
      },
    ],
  },
  {
    id: 226,
    slug: 'invert-binary-tree',
    title: '翻转二叉树',
    titleEn: 'Invert Binary Tree',
    difficulty: '简单',
    category: '二叉树',
    officialTags: ['树', '深度优先搜索', '广度优先搜索', '二叉树'],
    studyTags: ['交换子树', '结构递归', '树的遍历'],
    summary: '交换二叉树中每个结点的左右子树，返回翻转后的根结点。',
    insight: '整棵树的镜像由根结点交换左右孩子，以及两个子树各自完成镜像组成。',
    pitfalls: ['需要交换每一个非空结点', '注意保存或同时交换引用', '允许原地修改树结构'],
    sourceUrl: 'https://leetcode.cn/problems/invert-binary-tree/',
    solutions: [
      {
        id: 'recursive-dfs',
        title: '递归 DFS',
        kind: '最优',
        idea: '交换当前结点的左右孩子，再递归翻转两个孩子。',
        steps: ['空结点直接返回', '交换 left 与 right', '递归处理交换后的两个子树'],
        complexity: { time: 'O(n)', space: 'O(h)' },
        code: {
          java: `class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}`,
          kotlin: `class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root.left = root.right.also { root.right = root.left }
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}`,
          cpp: `class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr;
        swap(root->left, root->right);
        invertTree(root->left);
        invertTree(root->right);
        return root;
    }
};`,
        },
      },
      {
        id: 'iterative-bfs',
        title: '队列 BFS',
        kind: '进阶',
        idea: '逐层取出结点、交换孩子，再把非空孩子放入队列。',
        steps: ['根结点非空则入队', '弹出并交换左右孩子', '把交换后的非空孩子入队'],
        complexity: { time: 'O(n)', space: 'O(w)' },
        code: {
          java: `class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}`,
          kotlin: `class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue = java.util.ArrayDeque<TreeNode>()
        queue.offer(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            node.left = node.right.also { node.right = node.left }
            node.left?.let(queue::offer)
            node.right?.let(queue::offer)
        }
        return root
    }
}`,
          cpp: `class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr;
        queue<TreeNode*> nodes;
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode* node = nodes.front(); nodes.pop();
            swap(node->left, node->right);
            if (node->left) nodes.push(node->left);
            if (node->right) nodes.push(node->right);
        }
        return root;
    }
};`,
        },
      },
    ],
  },
]
