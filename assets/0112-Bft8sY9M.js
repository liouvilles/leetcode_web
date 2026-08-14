const c=112,t="path-sum",n="Path Sum",g="简单",o="树与高级结构",r=["树","深度优先搜索","广度优先搜索","二叉树"],h=!1,a="https://leetcode.cn/problems/path-sum/",e="路径总和",i=["深度优先搜索","剩余目标","根到叶路径"],l="判断二叉树中是否存在一条从根节点到叶节点的路径，其节点值之和等于目标值。",s="沿路径递归扣除当前节点值，到达叶节点时检查剩余目标是否正好等于叶节点值。",u=["路径必须在叶节点结束","不能把任意中间节点当作终点","节点值和目标都可能为负数"],m=[{id:"remaining-sum-dfs",title:"剩余目标 DFS",kind:"最优",idea:"递归把问题缩小为子树中是否存在和为 target-current 的根到叶路径。",steps:["空节点返回假","叶节点直接比较当前值和剩余目标","对左右子树递归并取或"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }
}
`,kotlin:`class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        root ?: return false
        if (root.left == null && root.right == null) return root.\`val\` == targetSum
        val remaining = targetSum - root.\`val\`
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)
    }
}
`,cpp:`class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (!root) return false;
        if (!root->left && !root->right) return root->val == targetSum;
        int remaining = targetSum - root->val;
        return hasPathSum(root->left, remaining) || hasPathSum(root->right, remaining);
    }
};
`}}],f={id:112,slug:t,titleEn:n,difficulty:"简单",category:o,officialTags:r,paidOnly:!1,sourceUrl:a,title:e,studyTags:i,summary:l,insight:s,pitfalls:u,solutions:m};export{o as category,f as default,g as difficulty,c as id,s as insight,r as officialTags,h as paidOnly,u as pitfalls,t as slug,m as solutions,a as sourceUrl,i as studyTags,l as summary,e as title,n as titleEn};
