const f=114,t="flatten-binary-tree-to-linked-list",o="Flatten Binary Tree to Linked List",p="中等",e="树与高级结构",r=["链表","栈","树","深度优先搜索","二叉树"],d=!1,n="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/",l="二叉树展开为链表",i=["二叉树","逆前序遍历","原地修改"],s="把二叉树原地展开成只使用右指针的链表，节点顺序与原树前序遍历一致。",u="按右、左、根的逆前序递归，维护已展开部分的头节点；当前节点右指向它、左置空即可。",a=["结果中所有左指针都必须为空","递归顺序必须先右后左","不能新建替代节点"],c=[{id:"reverse-preorder",title:"逆前序递归串联",kind:"最优",idea:"从前序的末尾向前构造右链，previous 始终指向当前节点的后继。",steps:["先递归右子树","再递归左子树","当前 right=previous、left=null，并更新 previous"],complexity:{time:"O(n)",space:"O(h)"},code:{java:`class Solution {
    private TreeNode previous;
    public void flatten(TreeNode root) { if (root == null) return; flatten(root.right); flatten(root.left); root.right = previous; root.left = null; previous = root; }
}
`,kotlin:`class Solution {
    private var previous: TreeNode? = null
    fun flatten(root: TreeNode?) { if (root == null) return; flatten(root.right); flatten(root.left); root.right = previous; root.left = null; previous = root }
}
`,cpp:`class Solution {
    TreeNode* previous = nullptr;
public:
    void flatten(TreeNode* root) { if (!root) return; flatten(root->right); flatten(root->left); root->right = previous; root->left = nullptr; previous = root; }
};
`}}],v={id:114,slug:t,titleEn:o,difficulty:"中等",category:e,officialTags:r,paidOnly:!1,sourceUrl:n,title:l,studyTags:i,summary:s,insight:u,pitfalls:a,solutions:c};export{e as category,v as default,p as difficulty,f as id,u as insight,r as officialTags,d as paidOnly,a as pitfalls,t as slug,c as solutions,n as sourceUrl,i as studyTags,s as summary,l as title,o as titleEn};
