const f=102,e="binary-tree-level-order-traversal",n="Binary Tree Level Order Traversal",p="中等",t="树与高级结构",r=["树","广度优先搜索","二叉树"],c=!1,l="https://leetcode.cn/problems/binary-tree-level-order-traversal/",s="二叉树的层序遍历",o=["分层 BFS","队列快照","深度分组"],d="从根结点开始逐层、从左到右收集二叉树的结点值。",i="每轮开始时队列的长度，恰好是当前层尚未处理的结点数。",u=["空树返回空列表","必须在处理本层前固定 size","DFS 版本要在首次抵达某深度时建组"],a=[{id:"bfs",title:"队列分层 BFS",kind:"最优",idea:"队列保存下一批待访问结点，用每轮的固定队列长度划分层级。",steps:["根结点入队","记录当前队列长度并处理恰好这么多个结点","把子结点入队并保存本层结果"],complexity:{time:"O(n)",space:"O(w)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}},{id:"dfs-by-depth",title:"按深度分组 DFS",kind:"进阶",idea:"深度优先访问时携带 depth，把同一深度的结点追加到同一个列表。",steps:["首次到达 depth 时创建列表","把当前值加入 result[depth]","依次递归左右子树并令深度加一"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
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
}
`,kotlin:`class Solution {
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
}
`,cpp:`class Solution {
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
};
`}}],v={id:102,slug:e,titleEn:n,difficulty:"中等",category:t,officialTags:r,paidOnly:!1,sourceUrl:l,title:s,studyTags:o,summary:d,insight:i,pitfalls:u,solutions:a};export{t as category,v as default,p as difficulty,f as id,i as insight,r as officialTags,c as paidOnly,u as pitfalls,e as slug,a as solutions,l as sourceUrl,o as studyTags,d as summary,s as title,n as titleEn};
