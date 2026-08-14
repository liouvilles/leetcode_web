const c=98,e="validate-binary-search-tree",n="Validate Binary Search Tree",p="中等",o="树与高级结构",l=["树","深度优先搜索","二叉搜索树","二叉树"],v=!1,t="https://leetcode.cn/problems/validate-binary-search-tree/",a="验证二叉搜索树",r=["上下界递归","严格有序","长整型边界"],i="判断一棵二叉树是否满足二叉搜索树性质：每个节点左子树的所有值更小，右子树的所有值更大。",d="节点不仅受父节点限制，还受到全部祖先传下来的开区间约束。",s=["只比较节点与直接孩子并不充分","相等值不满足严格二叉搜索树定义","整数极值要求边界类型比节点值范围更宽"],u=[{id:"recursive-bounds",title:"递归传递开区间",kind:"最优",idea:"为每个节点携带允许值的下界和上界，进入左右子树时分别收紧边界。",steps:["根节点从无限开区间开始","节点值必须严格位于上下界之间","左子树上界设为当前值，右子树下界设为当前值"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        if (node.val <= lower || node.val >= upper) return false;
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }
}
`,kotlin:`class Solution {
    fun isValidBST(root: TreeNode?): Boolean = validate(root, Long.MIN_VALUE, Long.MAX_VALUE)

    private fun validate(node: TreeNode?, lower: Long, upper: Long): Boolean {
        node ?: return true
        val value = node.\`val\`.toLong()
        if (value <= lower || value >= upper) return false
        return validate(node.left, lower, value) && validate(node.right, value, upper)
    }
}
`,cpp:`class Solution {
    bool validate(TreeNode* node, long long lower, long long upper) {
        if (!node) return true;
        if (node->val <= lower || node->val >= upper) return false;
        return validate(node->left, lower, node->val) && validate(node->right, node->val, upper);
    }
public:
    bool isValidBST(TreeNode* root) {
        return validate(root, LLONG_MIN, LLONG_MAX);
    }
};
`}}],f={id:98,slug:e,titleEn:n,difficulty:"中等",category:o,officialTags:l,paidOnly:!1,sourceUrl:t,title:a,studyTags:r,summary:i,insight:d,pitfalls:s,solutions:u};export{o as category,f as default,p as difficulty,c as id,d as insight,l as officialTags,v as paidOnly,s as pitfalls,e as slug,u as solutions,t as sourceUrl,r as studyTags,i as summary,a as title,n as titleEn};
