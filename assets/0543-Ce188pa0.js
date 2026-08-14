const f=543,e="diameter-of-binary-tree",t="Diameter of Binary Tree",m="简单",i="动态规划",r=["树","深度优先搜索","二叉树","树形 DP"],c=!1,n="https://leetcode.cn/problems/diameter-of-binary-tree/",o="二叉树的直径",a=["后序遍历","子树高度","全局最优"],d="求二叉树中任意两个节点之间最长路径所经过的边数，路径不一定经过根。",h="以某节点为最高点的最长路径边数等于左子树高度加右子树高度，后序遍历所有节点即可取最大。",l=["直径按边数而不是节点数计算","最优路径可能完全位于某个子树","高度返回较大子树高度加一"],s=[{id:"postorder-heights",title:"后序高度合并",kind:"最优",idea:"递归返回节点高度，并用左右高度之和更新全局直径。",steps:["空节点高度为零","递归求左右高度","更新直径并返回 max(left,right)+1"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) { diameter = 0; height(root); return diameter; }
    private int height(TreeNode node) { if (node == null) return 0; int left = height(node.left), right = height(node.right); diameter = Math.max(diameter, left + right); return Math.max(left, right) + 1; }
}
`,kotlin:`class Solution {
    private var diameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int { diameter = 0; height(root); return diameter }
    private fun height(node: TreeNode?): Int { node ?: return 0; val left = height(node.left); val right = height(node.right); diameter = maxOf(diameter, left + right); return maxOf(left, right) + 1 }
}
`,cpp:`class Solution {
    int diameter = 0;
    int height(TreeNode* node) { if (!node) return 0; int left = height(node->left), right = height(node->right); diameter = max(diameter, left + right); return max(left, right) + 1; }
public:
    int diameterOfBinaryTree(TreeNode* root) { diameter = 0; height(root); return diameter; }
};
`}}],g={id:543,slug:e,titleEn:t,difficulty:"简单",category:i,officialTags:r,paidOnly:!1,sourceUrl:n,title:o,studyTags:a,summary:d,insight:h,pitfalls:l,solutions:s};export{i as category,g as default,m as difficulty,f as id,h as insight,r as officialTags,c as paidOnly,l as pitfalls,e as slug,s as solutions,n as sourceUrl,a as studyTags,d as summary,o as title,t as titleEn};
