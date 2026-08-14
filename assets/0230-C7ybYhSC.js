const k=230,e="kth-smallest-element-in-a-bst",t="Kth Smallest Element in a BST",u="中等",n="树与高级结构",o=["树","深度优先搜索","二叉搜索树","二叉树"],h=!1,s="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/",l="二叉搜索树中第 K 小的元素",a=["中序遍历","二叉搜索树","迭代栈"],i="在二叉搜索树中找出按值升序排列后的第 k 个元素。",d="二叉搜索树中序遍历天然按升序产生节点，弹出栈中的第 k 个节点即可返回。",c=["k 从一开始计数","必须先沿左链压栈","弹出节点后转向它的右子树"],r=[{id:"iterative-inorder",title:"迭代中序遍历",kind:"最优",idea:"显式栈逐个生成升序节点，并在第 k 次弹栈时停止。",steps:["沿当前节点左链入栈","弹栈后递减 k","k 为零返回，否则转向右孩子"],complexity:{time:"O(h+k)",space:"O(h)"},code:{java:`class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>(); TreeNode node = root;
        while (true) { while (node != null) { stack.push(node); node = node.left; } node = stack.pop(); if (--k == 0) return node.val; node = node.right; }
    }
}
`,kotlin:`class Solution {
    fun kthSmallest(root: TreeNode?, inputK: Int): Int {
        val stack: ArrayDeque<TreeNode> = ArrayDeque(); var node = root; var k = inputK
        while (true) { while (node != null) { stack.addLast(node); node = node.left }; node = stack.removeLast(); if (--k == 0) return node.\`val\`; node = node.right }
    }
}
`,cpp:`class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<TreeNode*> stack; TreeNode* node = root;
        while (true) { while (node) { stack.push_back(node); node = node->left; } node = stack.back(); stack.pop_back(); if (--k == 0) return node->val; node = node->right; }
    }
};
`}}],p={id:230,slug:e,titleEn:t,difficulty:"中等",category:n,officialTags:o,paidOnly:!1,sourceUrl:s,title:l,studyTags:a,summary:i,insight:d,pitfalls:c,solutions:r};export{n as category,p as default,u as difficulty,k as id,d as insight,o as officialTags,h as paidOnly,c as pitfalls,e as slug,r as solutions,s as sourceUrl,a as studyTags,i as summary,l as title,t as titleEn};
