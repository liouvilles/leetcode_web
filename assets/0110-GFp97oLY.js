const d=110,t="balanced-binary-tree",e="Balanced Binary Tree",f="简单",n="树与高级结构",i=["树","深度优先搜索","二叉树"],g=!1,r="https://leetcode.cn/problems/balanced-binary-tree/",o="平衡二叉树",l=["后序遍历","高度剪枝","哨兵返回值"],a="判断一棵二叉树是否满足每个节点左右子树高度差不超过一。",h="后序计算高度时用 -1 表示子树已经不平衡，可以立即向上传播并停止无用计算。",s=["平衡条件必须对每个节点成立","重复单独计算高度会退化为平方时间","空树高度可定义为零"],c=[{id:"height-or-failure",title:"高度与失败合并返回",kind:"最优",idea:"一次后序遍历同时完成高度计算和平衡性判断。",steps:["递归得到左右子树高度","任一返回 -1 或高度差超过一就返回 -1","否则返回较大高度加一"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public boolean isBalanced(TreeNode root) { return height(root) >= 0; }
    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left); if (left < 0) return -1;
        int right = height(node.right); if (right < 0 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
`,kotlin:`class Solution {
    fun isBalanced(root: TreeNode?): Boolean = height(root) >= 0
    private fun height(node: TreeNode?): Int {
        node ?: return 0
        val left = height(node.left); if (left < 0) return -1
        val right = height(node.right); if (right < 0 || kotlin.math.abs(left - right) > 1) return -1
        return maxOf(left, right) + 1
    }
}
`,cpp:`class Solution {
    int height(TreeNode* node) {
        if (!node) return 0;
        int left = height(node->left); if (left < 0) return -1;
        int right = height(node->right); if (right < 0 || abs(left - right) > 1) return -1;
        return max(left, right) + 1;
    }
public:
    bool isBalanced(TreeNode* root) { return height(root) >= 0; }
};
`}}],u={id:110,slug:t,titleEn:e,difficulty:"简单",category:n,officialTags:i,paidOnly:!1,sourceUrl:r,title:o,studyTags:l,summary:a,insight:h,pitfalls:s,solutions:c};export{n as category,u as default,f as difficulty,d as id,h as insight,i as officialTags,g as paidOnly,s as pitfalls,t as slug,c as solutions,r as sourceUrl,l as studyTags,a as summary,o as title,e as titleEn};
