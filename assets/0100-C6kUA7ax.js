const f=100,e="same-tree",s="Same Tree",u="简单",n="树与高级结构",t=["树","深度优先搜索","广度优先搜索","二叉树"],T=!1,i="https://leetcode.cn/problems/same-tree/",o="相同的树",r=["同步递归","结构比较","二叉树"],c="判断两棵二叉树在结构和每个对应节点的值上是否完全相同。",l="同步检查两个当前位置：同时为空相同，一空一非空或值不同则失败，其余递归比较左右孩子。",a=["仅遍历节点值会遗漏结构差异","两个空节点应返回真","左右子树必须按相同方向对应"],d=[{id:"synchronous-recursion",title:"同步递归比较",kind:"最优",idea:"每次递归处理一对对应节点并组合左右子树结果。",steps:["同时为空返回真","空状态或值不同返回假","递归比较左对左、右对右"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public boolean isSameTree(TreeNode first, TreeNode second) {
        if (first == null || second == null) return first == second;
        return first.val == second.val && isSameTree(first.left, second.left) && isSameTree(first.right, second.right);
    }
}
`,kotlin:`class Solution {
    fun isSameTree(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null || second == null) return first === second
        return first.\`val\` == second.\`val\` && isSameTree(first.left, second.left) && isSameTree(first.right, second.right)
    }
}
`,cpp:`class Solution {
public:
    bool isSameTree(TreeNode* first, TreeNode* second) {
        if (!first || !second) return first == second;
        return first->val == second->val && isSameTree(first->left, second->left) && isSameTree(first->right, second->right);
    }
};
`}}],m={id:100,slug:e,titleEn:s,difficulty:"简单",category:n,officialTags:t,paidOnly:!1,sourceUrl:i,title:o,studyTags:r,summary:c,insight:l,pitfalls:a,solutions:d};export{n as category,m as default,u as difficulty,f as id,l as insight,t as officialTags,T as paidOnly,a as pitfalls,e as slug,d as solutions,i as sourceUrl,r as studyTags,c as summary,o as title,s as titleEn};
