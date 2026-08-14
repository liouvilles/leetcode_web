const u=145,e="binary-tree-postorder-traversal",t="Binary Tree Postorder Traversal",p="简单",s="树与高级结构",o=["栈","树","深度优先搜索","二叉树"],f=!1,r="https://leetcode.cn/problems/binary-tree-postorder-traversal/",n="二叉树的后序遍历",a=["二叉树","迭代","栈"],d="返回二叉树节点值的后序遍历序列，即依次访问左子树、右子树、根。",i="用栈生成根、右、左顺序，最后整体反转即可得到左、右、根，避免记录节点访问状态。",l=["压入左孩子后再压右孩子才能先处理右侧","最终必须反转临时序列","空树无需入栈"],c=[{id:"reverse-root-right-left",title:"根右左后反转",kind:"最优",idea:"把后序视为根右左序列的逆序，用一次反转完成。",steps:["根节点入栈","弹出记录，并依次压左、右孩子","遍历结束反转答案"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public List<Integer> postorderTraversal(TreeNode root) { LinkedList<Integer> answer = new LinkedList<>(); if (root == null) return answer; Deque<TreeNode> stack = new ArrayDeque<>(); stack.push(root); while (!stack.isEmpty()) { TreeNode node = stack.pop(); answer.addFirst(node.val); if (node.left != null) stack.push(node.left); if (node.right != null) stack.push(node.right); } return answer; }
}
`,kotlin:`class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> { if (root == null) return emptyList(); val answer = mutableListOf<Int>(); val stack = ArrayDeque<TreeNode>(); stack.addLast(root); while (stack.isNotEmpty()) { val node = stack.removeLast(); answer.add(node.\`val\`); node.left?.let { stack.addLast(it) }; node.right?.let { stack.addLast(it) } }; answer.reverse(); return answer }
}
`,cpp:`class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) { vector<int> answer; if (!root) return answer; stack<TreeNode*> nodes; nodes.push(root); while (!nodes.empty()) { TreeNode* node = nodes.top(); nodes.pop(); answer.push_back(node->val); if (node->left) nodes.push(node->left); if (node->right) nodes.push(node->right); } reverse(answer.begin(), answer.end()); return answer; }
};
`}}],h={id:145,slug:e,titleEn:t,difficulty:"简单",category:s,officialTags:o,paidOnly:!1,sourceUrl:r,title:n,studyTags:a,summary:d,insight:i,pitfalls:l,solutions:c};export{s as category,h as default,p as difficulty,u as id,i as insight,o as officialTags,f as paidOnly,l as pitfalls,e as slug,c as solutions,r as sourceUrl,a as studyTags,d as summary,n as title,t as titleEn};
