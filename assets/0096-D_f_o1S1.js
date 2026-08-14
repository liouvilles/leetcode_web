const f=96,n="unique-binary-search-trees",t="Unique Binary Search Trees",a="中等",e="动态规划",s=["数学","动态规划","树","二叉搜索树","二叉树"],u=!1,o="https://leetcode.cn/problems/unique-binary-search-trees/",d="不同的二叉搜索树",i=["动态规划","卡特兰数","树形计数"],l="计算由 1 到 n 组成且节点值各不相同的二叉搜索树一共有多少种结构。",p="选择 root 后，左右子树的节点数量确定且结构选择相互独立；枚举根并累加左右方案数乘积。",c=["空子树的方案数为一","只与节点数量有关而与具体值无关","每个根都要计入总和"],r=[{id:"catalan-dp",title:"卡特兰动态规划",kind:"最优",idea:"dp[nodes] 表示给定节点数的不同 BST 数量，通过根位置划分左右规模。",steps:["dp[0]=dp[1]=1","枚举总节点数","枚举左子树节点数并累加 dp[left]*dp[right]"],complexity:{time:"O(n²)",space:"O(n)"},code:{java:`class Solution {
    public int numTrees(int n) { int[] dp = new int[n + 1]; dp[0] = 1; for (int nodes = 1; nodes <= n; nodes++) for (int left = 0; left < nodes; left++) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n]; }
}
`,kotlin:`class Solution {
    fun numTrees(n: Int): Int { val dp = IntArray(n + 1); dp[0] = 1; for (nodes in 1..n) for (left in 0 until nodes) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n] }
}
`,cpp:`class Solution {
public:
    int numTrees(int n) { vector<int> dp(n + 1); dp[0] = 1; for (int nodes = 1; nodes <= n; ++nodes) for (int left = 0; left < nodes; ++left) dp[nodes] += dp[left] * dp[nodes - 1 - left]; return dp[n]; }
};
`}}],y={id:96,slug:n,titleEn:t,difficulty:"中等",category:e,officialTags:s,paidOnly:!1,sourceUrl:o,title:d,studyTags:i,summary:l,insight:p,pitfalls:c,solutions:r};export{e as category,y as default,a as difficulty,f as id,p as insight,s as officialTags,u as paidOnly,c as pitfalls,n as slug,r as solutions,o as sourceUrl,i as studyTags,l as summary,d as title,t as titleEn};
