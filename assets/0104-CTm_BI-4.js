const p=104,e="maximum-depth-of-binary-tree",n="Maximum Depth of Binary Tree",f="简单",t="树与高级结构",o=["树","深度优先搜索","广度优先搜索","二叉树"],h=!1,r="https://leetcode.cn/problems/maximum-depth-of-binary-tree/",i="二叉树的最大深度",u=["树高","后序递归","分层计数"],l="求从根结点到最远叶子结点的最长路径所包含的结点数。",s="一棵非空树的高度等于左右子树较大高度加一。",d=["空树深度为 0","题目计算结点数而不是边数","极端链状树会产生 O(n) 递归深度"],a=[{id:"recursive-dfs",title:"递归求树高",kind:"最优",idea:"递归获得左右子树高度，当前结点高度取较大者加一。",steps:["空结点返回 0","递归计算左右高度","返回 max(left, right) + 1"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
`,kotlin:`class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return maxOf(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}
`,cpp:`class Solution {
public:
    int maxDepth(TreeNode* root) {
        if (!root) return 0;
        return max(maxDepth(root->left), maxDepth(root->right)) + 1;
    }
};
`}},{id:"level-bfs",title:"层序遍历计数",kind:"进阶",idea:"每完成一层 BFS 就把深度加一，最后处理的层就是最深层。",steps:["根结点入队","按当前队列长度消费一整层","加入子结点并递增深度"],complexity:{time:"O(n)",space:"O(w)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}}],c={id:104,slug:e,titleEn:n,difficulty:"简单",category:t,officialTags:o,paidOnly:!1,sourceUrl:r,title:i,studyTags:u,summary:l,insight:s,pitfalls:d,solutions:a};export{t as category,c as default,f as difficulty,p as id,s as insight,o as officialTags,h as paidOnly,d as pitfalls,e as slug,a as solutions,r as sourceUrl,u as studyTags,l as summary,i as title,n as titleEn};
