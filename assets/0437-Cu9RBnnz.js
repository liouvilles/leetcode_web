const l=437,t="path-sum-iii",n="Path Sum III",d="中等",e="树与高级结构",r=["树","深度优先搜索","二叉树"],p=!1,o="https://leetcode.cn/problems/path-sum-iii/",u="路径总和 III",s=["前缀和","树上 DFS","回溯计数"],c="统计二叉树中节点值之和等于目标值的向下路径数量；路径可以从任意节点开始，但必须沿父子方向连续。",i="若当前根到节点前缀和为 current，之前出现过 current-target 的前缀次数就是以当前节点结尾的合法路径数。",a=["路径不必从根开始或在叶结束","节点值累加需要长整型","离开子树时必须撤销当前前缀计数"],g=[{id:"prefix-sum-dfs",title:"树上前缀和回溯",kind:"最优",idea:"DFS 路径上维护前缀和频次，进入节点增加、退出节点撤销。",steps:["初始化前缀零出现一次","累加当前值并查询 current-target","登记当前前缀、递归孩子、最后撤销"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> counts = new HashMap<>(); counts.put(0L, 1); return visit(root, 0L, targetSum, counts);
    }
    private int visit(TreeNode node, long prefix, long target, Map<Long, Integer> counts) {
        if (node == null) return 0;
        long current = prefix + node.val; int answer = counts.getOrDefault(current - target, 0); counts.put(current, counts.getOrDefault(current, 0) + 1);
        answer += visit(node.left, current, target, counts) + visit(node.right, current, target, counts);
        counts.put(current, counts.get(current) - 1); return answer;
    }
}
`,kotlin:`class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int { val counts = HashMap<Long, Int>(); counts[0L] = 1; return visit(root, 0L, targetSum.toLong(), counts) }
    private fun visit(node: TreeNode?, prefix: Long, target: Long, counts: MutableMap<Long, Int>): Int {
        node ?: return 0
        val current = prefix + node.\`val\`; var answer = counts[current - target] ?: 0; counts[current] = (counts[current] ?: 0) + 1
        answer += visit(node.left, current, target, counts) + visit(node.right, current, target, counts)
        counts[current] = counts.getValue(current) - 1; return answer
    }
}
`,cpp:`class Solution {
    int visit(TreeNode* node, long long prefix, long long target, unordered_map<long long, int>& counts) {
        if (!node) return 0;
        long long current = prefix + node->val; int answer = counts[current - target]; ++counts[current];
        answer += visit(node->left, current, target, counts) + visit(node->right, current, target, counts);
        --counts[current]; return answer;
    }
public:
    int pathSum(TreeNode* root, int targetSum) { unordered_map<long long, int> counts{{0, 1}}; return visit(root, 0, targetSum, counts); }
};
`}}],f={id:437,slug:t,titleEn:n,difficulty:"中等",category:e,officialTags:r,paidOnly:!1,sourceUrl:o,title:u,studyTags:s,summary:c,insight:i,pitfalls:a,solutions:g};export{e as category,f as default,d as difficulty,l as id,i as insight,r as officialTags,p as paidOnly,a as pitfalls,t as slug,g as solutions,o as sourceUrl,s as studyTags,c as summary,u as title,n as titleEn};
