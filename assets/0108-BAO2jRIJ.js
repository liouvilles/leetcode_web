const c=108,t="convert-sorted-array-to-binary-search-tree",e="Convert Sorted Array to Binary Search Tree",m="简单",r="树与高级结构",n=["数组","分治","树","二叉搜索树","二叉树"],f=!1,i="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/",o="将有序数组转换为二叉搜索树",l=["二叉搜索树","递归分治","平衡树"],d="把严格递增数组转换为一棵高度平衡的二叉搜索树。",s="每次选择区间中点作为根，左右半区分别递归建树，子树规模之差自然不超过一。",u=["空区间返回空节点","中点选上中位或下中位都可","结果需同时满足 BST 与高度平衡"],a=[{id:"middle-as-root",title:"中点递归建树",kind:"最优",idea:"把数组中点作为根，并对左右子区间重复相同过程。",steps:["递归接收闭区间 left/right","选 middle 并创建根","左右区间分别构造子树"],complexity:{time:"O(n)",space:"O(log n)"},code:{java:`class Solution {
    public TreeNode sortedArrayToBST(int[] nums) { return build(nums, 0, nums.length - 1); }
    private TreeNode build(int[] nums, int left, int right) { if (left > right) return null; int middle = left + (right - left) / 2; TreeNode root = new TreeNode(nums[middle]); root.left = build(nums, left, middle - 1); root.right = build(nums, middle + 1, right); return root; }
}
`,kotlin:`class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? { fun build(left: Int, right: Int): TreeNode? { if (left > right) return null; val middle = left + (right - left) / 2; val root = TreeNode(nums[middle]); root.left = build(left, middle - 1); root.right = build(middle + 1, right); return root }; return build(0, nums.lastIndex) }
}
`,cpp:`class Solution {
    TreeNode* build(vector<int>& nums, int left, int right) { if (left > right) return nullptr; int middle = left + (right - left) / 2; TreeNode* root = new TreeNode(nums[middle]); root->left = build(nums, left, middle - 1); root->right = build(nums, middle + 1, right); return root; }
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) { return build(nums, 0, nums.size() - 1); }
};
`}}],g={id:108,slug:t,titleEn:e,difficulty:"简单",category:r,officialTags:n,paidOnly:!1,sourceUrl:i,title:o,studyTags:l,summary:d,insight:s,pitfalls:u,solutions:a};export{r as category,g as default,m as difficulty,c as id,s as insight,n as officialTags,f as paidOnly,u as pitfalls,t as slug,a as solutions,i as sourceUrl,l as studyTags,d as summary,o as title,e as titleEn};
