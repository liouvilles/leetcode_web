const c=226,e="invert-binary-tree",n="Invert Binary Tree",a="简单",o="树与高级结构",t=["树","深度优先搜索","广度优先搜索","二叉树"],p=!1,r="https://leetcode.cn/problems/invert-binary-tree/",i="翻转二叉树",l=["交换子树","结构递归","树的遍历"],u="交换二叉树中每个结点的左右子树，返回翻转后的根结点。",d="整棵树的镜像由根结点交换左右孩子，以及两个子树各自完成镜像组成。",s=["需要交换每一个非空结点","注意保存或同时交换引用","允许原地修改树结构"],f=[{id:"recursive-dfs",title:"递归 DFS",kind:"最优",idea:"交换当前结点的左右孩子，再递归翻转两个孩子。",steps:["空结点直接返回","交换 left 与 right","递归处理交换后的两个子树"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
`,kotlin:`class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root.left = root.right.also { root.right = root.left }
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}
`,cpp:`class Solution {
public:
    TreeNode* invertTree(TreeNode* root) {
        if (!root) return nullptr;
        swap(root->left, root->right);
        invertTree(root->left);
        invertTree(root->right);
        return root;
    }
};
`}},{id:"iterative-bfs",title:"队列 BFS",kind:"进阶",idea:"逐层取出结点、交换孩子，再把非空孩子放入队列。",steps:["根结点非空则入队","弹出并交换左右孩子","把交换后的非空孩子入队"],complexity:{time:"O(n)",space:"O(w)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}}],T={id:226,slug:e,titleEn:n,difficulty:"简单",category:o,officialTags:t,paidOnly:!1,sourceUrl:r,title:i,studyTags:l,summary:u,insight:d,pitfalls:s,solutions:f};export{o as category,T as default,a as difficulty,c as id,d as insight,t as officialTags,p as paidOnly,s as pitfalls,e as slug,f as solutions,r as sourceUrl,l as studyTags,u as summary,i as title,n as titleEn};
