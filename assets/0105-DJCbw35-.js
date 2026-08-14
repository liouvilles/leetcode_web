const p=105,e="construct-binary-tree-from-preorder-and-inorder-traversal",r="Construct Binary Tree from Preorder and Inorder Traversal",c="中等",n="树与高级结构",t=["数组","哈希表","分治","树","二叉树"],x=!1,d="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/",i="从前序与中序遍历序列构造二叉树",o=["递归建树","中序分割","下标映射"],l="根据一棵无重复值二叉树的前序遍历和中序遍历序列，还原并返回这棵树。",a="前序序列按顺序提供每棵子树的根；根在中序序列中的位置则把左右子树区间准确分开。",u=["前序下标应按根、左、右的递归顺序递增","中序区间使用闭区间时边界要一致","节点值互不重复才能建立唯一位置映射"],s=[{id:"preorder-index-map",title:"前序指针 + 中序下标表",kind:"最优",idea:"哈希表保存每个值在中序序列的位置，用单调递增的前序指针依次创建根节点。",steps:["建立中序值到下标的映射","读取当前前序值创建根节点","按中序根位置递归构造左区间和右区间"],complexity:{time:"O(n)",space:"O(n)"},code:{java:`class Solution {
    private int preorderIndex;
    private int[] preorder;
    private Map<Integer, Integer> inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.preorderIndex = 0;
        this.inorderIndex = new HashMap<>();
        for (int index = 0; index < inorder.length; index++) inorderIndex.put(inorder[index], index);
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) return null;
        int value = preorder[preorderIndex++];
        TreeNode root = new TreeNode(value);
        int middle = inorderIndex.get(value);
        root.left = build(left, middle - 1);
        root.right = build(middle + 1, right);
        return root;
    }
}
`,kotlin:`class Solution {
    private var preorderIndex = 0
    private lateinit var preorderValues: IntArray
    private lateinit var inorderIndex: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        preorderValues = preorder
        preorderIndex = 0
        inorderIndex = inorder.withIndex().associate { it.value to it.index }
        return build(0, inorder.lastIndex)
    }

    private fun build(left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val value = preorderValues[preorderIndex++]
        val root = TreeNode(value)
        val middle = inorderIndex.getValue(value)
        root.left = build(left, middle - 1)
        root.right = build(middle + 1, right)
        return root
    }
}
`,cpp:`class Solution {
    int preorderIndex = 0;
    vector<int>* preorderValues = nullptr;
    unordered_map<int, int> inorderIndex;

    TreeNode* build(int left, int right) {
        if (left > right) return nullptr;
        int value = (*preorderValues)[preorderIndex++];
        TreeNode* root = new TreeNode(value);
        int middle = inorderIndex[value];
        root->left = build(left, middle - 1);
        root->right = build(middle + 1, right);
        return root;
    }
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        preorderValues = &preorder;
        preorderIndex = 0;
        inorderIndex.clear();
        for (int index = 0; index < (int)inorder.size(); ++index) inorderIndex[inorder[index]] = index;
        return build(0, (int)inorder.size() - 1);
    }
};
`}}],I={id:105,slug:e,titleEn:r,difficulty:"中等",category:n,officialTags:t,paidOnly:!1,sourceUrl:d,title:i,studyTags:o,summary:l,insight:a,pitfalls:u,solutions:s};export{n as category,I as default,c as difficulty,p as id,a as insight,t as officialTags,x as paidOnly,u as pitfalls,e as slug,s as solutions,d as sourceUrl,o as studyTags,l as summary,i as title,r as titleEn};
