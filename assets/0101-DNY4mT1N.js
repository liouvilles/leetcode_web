const h=101,t="symmetric-tree",r="Symmetric Tree",a="简单",e="树与高级结构",o=["树","深度优先搜索","广度优先搜索","二叉树"],m=!1,i="https://leetcode.cn/problems/symmetric-tree/",n="对称二叉树",l=["镜像递归","成对比较","树结构"],s="判断一棵二叉树是否关于根节点的中心轴左右镜像对称。",f="对称性要求左树的外侧对应右树的外侧，同时左树内侧对应右树内侧。",c=["节点值相等还不够，空节点位置也必须镜像","递归比较的是 left.left 与 right.right","空树可以视为对称"],g=[{id:"mirror-recursion",title:"镜像节点递归",kind:"最优",idea:"同时递归两个应当互为镜像的节点，并交叉比较它们的孩子。",steps:["根为空时直接返回真","一空一非空或值不同则失败","递归比较外侧节点对和内侧节点对"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || mirror(root.left, root.right);
    }

    private boolean mirror(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        return left.val == right.val
            && mirror(left.left, right.right)
            && mirror(left.right, right.left);
    }
}
`,kotlin:`class Solution {
    fun isSymmetric(root: TreeNode?): Boolean = root == null || mirror(root.left, root.right)

    private fun mirror(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null || right == null) return left === right
        return left.\`val\` == right.\`val\`
            && mirror(left.left, right.right)
            && mirror(left.right, right.left)
    }
}
`,cpp:`class Solution {
    bool mirror(TreeNode* left, TreeNode* right) {
        if (!left || !right) return left == right;
        return left->val == right->val
            && mirror(left->left, right->right)
            && mirror(left->right, right->left);
    }
public:
    bool isSymmetric(TreeNode* root) {
        return !root || mirror(root->left, root->right);
    }
};
`}}],u={id:101,slug:t,titleEn:r,difficulty:"简单",category:e,officialTags:o,paidOnly:!1,sourceUrl:i,title:n,studyTags:l,summary:s,insight:f,pitfalls:c,solutions:g};export{e as category,u as default,a as difficulty,h as id,f as insight,o as officialTags,m as paidOnly,c as pitfalls,t as slug,g as solutions,i as sourceUrl,l as studyTags,s as summary,n as title,r as titleEn};
