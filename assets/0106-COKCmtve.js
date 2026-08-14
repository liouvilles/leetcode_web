const u=106,e="construct-binary-tree-from-inorder-and-postorder-traversal",t="Construct Binary Tree from Inorder and Postorder Traversal",c="中等",r="树与高级结构",o=["数组","哈希表","分治","树","二叉树"],f=!1,n="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/",i="从中序与后序遍历序列构造二叉树",d=["二叉树","递归分治","哈希索引"],s="根据无重复节点值的中序遍历和后序遍历数组，还原唯一的二叉树。",l="后序数组从末尾取根；由于消费顺序是根、右、左，递归时必须先构建右子树，再构建左子树。",p=["中序位置决定左右子树边界","后序下标应全局递减","递归构建顺序不能写反"],a=[{id:"reverse-postorder-recursion",title:"逆后序递归分治",kind:"最优",idea:"预存中序下标，按后序的根右左逆序消费节点。",steps:["建立 value 到 inorder 下标的映射","取 postorder[postIndex--] 为根","先递归右区间，再递归左区间"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    private int postIndex; private Map<Integer, Integer> positions;
    public TreeNode buildTree(int[] inorder, int[] postorder) { positions = new HashMap<>(); for (int index = 0; index < inorder.length; index++) positions.put(inorder[index], index); postIndex = postorder.length - 1; return build(0, inorder.length - 1, postorder); }
    private TreeNode build(int left, int right, int[] postorder) { if (left > right) return null; int value = postorder[postIndex--], middle = positions.get(value); TreeNode root = new TreeNode(value); root.right = build(middle + 1, right, postorder); root.left = build(left, middle - 1, postorder); return root; }
}
`,kotlin:`class Solution {
    private var postIndex = 0; private lateinit var positions: Map<Int, Int>
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? { positions = inorder.withIndex().associate { it.value to it.index }; postIndex = postorder.lastIndex; fun build(left: Int, right: Int): TreeNode? { if (left > right) return null; val value = postorder[postIndex--]; val middle = positions[value]!!; val root = TreeNode(value); root.right = build(middle + 1, right); root.left = build(left, middle - 1); return root }; return build(0, inorder.lastIndex) }
}
`,cpp:`class Solution {
    int postIndex; unordered_map<int, int> positions;
    TreeNode* build(int left, int right, vector<int>& postorder) { if (left > right) return nullptr; int value = postorder[postIndex--], middle = positions[value]; TreeNode* root = new TreeNode(value); root->right = build(middle + 1, right, postorder); root->left = build(left, middle - 1, postorder); return root; }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) { for (int index = 0; index < (int)inorder.size(); ++index) positions[inorder[index]] = index; postIndex = postorder.size() - 1; return build(0, inorder.size() - 1, postorder); }
};
`}}],v={id:106,slug:e,titleEn:t,difficulty:"中等",category:r,officialTags:o,paidOnly:!1,sourceUrl:n,title:i,studyTags:d,summary:s,insight:l,pitfalls:p,solutions:a};export{r as category,v as default,c as difficulty,u as id,l as insight,o as officialTags,f as paidOnly,p as pitfalls,e as slug,a as solutions,n as sourceUrl,d as studyTags,s as summary,i as title,t as titleEn};
