const u=124,n="binary-tree-maximum-path-sum",t="Binary Tree Maximum Path Sum",g="困难",e="动态规划",a=["动态规划","树","深度优先搜索","二叉树","树形 DP"],c=!1,r="https://leetcode.cn/problems/binary-tree-maximum-path-sum/",i="二叉树中的最大路径和",o=["树形 DP","后序遍历","负贡献剪枝"],s="在二叉树中选择一条不重复节点的连续路径，求路径节点值之和的最大值；路径起止点任意。",l="向父节点只能贡献左右分支中的一条，但以当前节点为最高点的完整路径可以同时连接左右两条正贡献分支。",d=["全负数树的答案是最大单节点值","负的子树贡献应按零处理","返回父节点的贡献不能同时包含左右两侧"],m=[{id:"postorder-gain",title:"后序最大贡献",kind:"最优",idea:"递归返回向上延伸的最大单支贡献，并用双支路径更新全局答案。",steps:["左右贡献分别与零取最大","候选完整路径为 node+left+right","向上返回 node+max(left,right)"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    private int answer;
    public int maxPathSum(TreeNode root) { answer = Integer.MIN_VALUE; gain(root); return answer; }
    private int gain(TreeNode node) { if (node == null) return 0; int left = Math.max(0, gain(node.left)), right = Math.max(0, gain(node.right)); answer = Math.max(answer, node.val + left + right); return node.val + Math.max(left, right); }
}
`,kotlin:`class Solution {
    private var answer = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int { answer = Int.MIN_VALUE; gain(root); return answer }
    private fun gain(node: TreeNode?): Int { node ?: return 0; val left = maxOf(0, gain(node.left)); val right = maxOf(0, gain(node.right)); answer = maxOf(answer, node.\`val\` + left + right); return node.\`val\` + maxOf(left, right) }
}
`,cpp:`class Solution {
    int answer = INT_MIN;
    int gain(TreeNode* node) { if (!node) return 0; int left = max(0, gain(node->left)), right = max(0, gain(node->right)); answer = max(answer, node->val + left + right); return node->val + max(left, right); }
public:
    int maxPathSum(TreeNode* root) { answer = INT_MIN; gain(root); return answer; }
};
`}}],f={id:124,slug:n,titleEn:t,difficulty:"困难",category:e,officialTags:a,paidOnly:!1,sourceUrl:r,title:i,studyTags:o,summary:s,insight:l,pitfalls:d,solutions:m};export{e as category,f as default,g as difficulty,u as id,l as insight,a as officialTags,c as paidOnly,d as pitfalls,n as slug,m as solutions,r as sourceUrl,o as studyTags,s as summary,i as title,t as titleEn};
