const c=199,e="binary-tree-right-side-view",n="Binary Tree Right Side View",f="中等",i="树与高级结构",t=["树","深度优先搜索","广度优先搜索","二叉树"],p=!1,o="https://leetcode.cn/problems/binary-tree-right-side-view/",r="二叉树的右视图",s=["层序遍历","每层末尾","广度优先搜索"],d="从二叉树右侧观察，返回从上到下每一层能够看到的节点值。",u="层序遍历时，每层队列中最后被处理的节点就是该层最右侧可见节点。",l=["可见节点不一定沿着右孩子链","每层开始时必须固定当前队列长度","空树返回空列表"],a=[{id:"level-order-last",title:"层序记录末节点",kind:"最优",idea:"按层消费队列，并在每层最后一个下标保存节点值。",steps:["根节点入队","固定当前层大小并逐个弹出","处理到层末时把值加入答案"],complexity:{time:"O(n)",space:"O(w)"},code:{java:`class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Queue<TreeNode> queue = new ArrayDeque<>(); queue.offer(root);
        while (!queue.isEmpty()) { int size = queue.size(); for (int index = 0; index < size; index++) { TreeNode node = queue.poll(); if (index == size - 1) answer.add(node.val); if (node.left != null) queue.offer(node.left); if (node.right != null) queue.offer(node.right); } }
        return answer;
    }
}
`,kotlin:`class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        val answer = ArrayList<Int>(); val queue: ArrayDeque<TreeNode> = ArrayDeque(); queue.add(root)
        while (queue.isNotEmpty()) { val size = queue.size; repeat(size) { index -> val node = queue.removeFirst(); if (index == size - 1) answer.add(node.\`val\`); node.left?.let(queue::add); node.right?.let(queue::add) } }
        return answer
    }
}
`,cpp:`class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if (!root) return {};
        vector<int> answer; queue<TreeNode*> pending; pending.push(root);
        while (!pending.empty()) { int size = pending.size(); for (int index = 0; index < size; ++index) { TreeNode* node = pending.front(); pending.pop(); if (index == size - 1) answer.push_back(node->val); if (node->left) pending.push(node->left); if (node->right) pending.push(node->right); } }
        return answer;
    }
};
`}}],g={id:199,slug:e,titleEn:n,difficulty:"中等",category:i,officialTags:t,paidOnly:!1,sourceUrl:o,title:r,studyTags:s,summary:d,insight:u,pitfalls:l,solutions:a};export{i as category,g as default,f as difficulty,c as id,u as insight,t as officialTags,p as paidOnly,l as pitfalls,e as slug,a as solutions,o as sourceUrl,s as studyTags,d as summary,r as title,n as titleEn};
