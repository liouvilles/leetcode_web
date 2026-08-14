const c=129,n="sum-root-to-leaf-numbers",e="Sum Root to Leaf Numbers",a="中等",t="树与高级结构",r=["树","深度优先搜索","二叉树"],p=!1,o="https://leetcode.cn/problems/sum-root-to-leaf-numbers/",s="求根节点到叶节点数字之和",u=["二叉树","深度优先搜索","路径累积"],i="树中每个节点保存一位数字，把每条根到叶路径视为一个十进制数，返回这些数的总和。",d="沿路径进入新节点时令当前值乘十再加节点数字；到叶子时把完整数字计入总和。",l=["只有叶子才结束一个数字","路径上的前导零自然有效","空树贡献零"],f=[{id:"dfs-number-building",title:"深度优先构造路径数字",kind:"最优",idea:"递归参数携带父路径数值，每深入一层追加一位。",steps:["空节点返回零","current=prefix*10+node.val","叶子返回 current，否则返回左右子树和"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public int sumNumbers(TreeNode root) { return dfs(root, 0); }
    private int dfs(TreeNode node, int prefix) { if (node == null) return 0; int current = prefix * 10 + node.val; if (node.left == null && node.right == null) return current; return dfs(node.left, current) + dfs(node.right, current); }
}
`,kotlin:`class Solution {
    fun sumNumbers(root: TreeNode?): Int { fun dfs(node: TreeNode?, prefix: Int): Int { if (node == null) return 0; val current = prefix * 10 + node.\`val\`; if (node.left == null && node.right == null) return current; return dfs(node.left, current) + dfs(node.right, current) }; return dfs(root, 0) }
}
`,cpp:`class Solution {
    int dfs(TreeNode* node, int prefix) { if (!node) return 0; int current = prefix * 10 + node->val; if (!node->left && !node->right) return current; return dfs(node->left, current) + dfs(node->right, current); }
public:
    int sumNumbers(TreeNode* root) { return dfs(root, 0); }
};
`}}],m={id:129,slug:n,titleEn:e,difficulty:"中等",category:t,officialTags:r,paidOnly:!1,sourceUrl:o,title:s,studyTags:u,summary:i,insight:d,pitfalls:l,solutions:f};export{t as category,m as default,a as difficulty,c as id,d as insight,r as officialTags,p as paidOnly,l as pitfalls,n as slug,f as solutions,o as sourceUrl,u as studyTags,i as summary,s as title,e as titleEn};
