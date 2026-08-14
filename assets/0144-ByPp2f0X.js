const u=144,e="binary-tree-preorder-traversal",t="Binary Tree Preorder Traversal",p="简单",r="树与高级结构",s=["栈","树","深度优先搜索","二叉树"],f=!1,o="https://leetcode.cn/problems/binary-tree-preorder-traversal/",n="二叉树的前序遍历",a=["二叉树","迭代","栈"],d="返回二叉树节点值的前序遍历序列，即依次访问根、左子树、右子树。",i="栈先压右孩子再压左孩子，后进先出的顺序会让左子树优先于右子树被访问。",l=["空树返回空列表","压栈顺序与访问顺序相反","每个节点只入栈一次"],c=[{id:"iterative-stack",title:"显式栈前序遍历",kind:"最优",idea:"弹栈时记录节点，并按右后左的压栈顺序维持根左右访问。",steps:["根非空时入栈","循环弹出并记录","先压右孩子，再压左孩子"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public List<Integer> preorderTraversal(TreeNode root) { List<Integer> answer = new ArrayList<>(); if (root == null) return answer; Deque<TreeNode> stack = new ArrayDeque<>(); stack.push(root); while (!stack.isEmpty()) { TreeNode node = stack.pop(); answer.add(node.val); if (node.right != null) stack.push(node.right); if (node.left != null) stack.push(node.left); } return answer; }
}
`,kotlin:`class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> { if (root == null) return emptyList(); val answer = mutableListOf<Int>(); val stack = ArrayDeque<TreeNode>(); stack.addLast(root); while (stack.isNotEmpty()) { val node = stack.removeLast(); answer.add(node.\`val\`); node.right?.let { stack.addLast(it) }; node.left?.let { stack.addLast(it) } }; return answer }
}
`,cpp:`class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) { vector<int> answer; if (!root) return answer; stack<TreeNode*> nodes; nodes.push(root); while (!nodes.empty()) { TreeNode* node = nodes.top(); nodes.pop(); answer.push_back(node->val); if (node->right) nodes.push(node->right); if (node->left) nodes.push(node->left); } return answer; }
};
`}}],h={id:144,slug:e,titleEn:t,difficulty:"简单",category:r,officialTags:s,paidOnly:!1,sourceUrl:o,title:n,studyTags:a,summary:d,insight:i,pitfalls:l,solutions:c};export{r as category,h as default,p as difficulty,u as id,i as insight,s as officialTags,f as paidOnly,l as pitfalls,e as slug,c as solutions,o as sourceUrl,a as studyTags,d as summary,n as title,t as titleEn};
