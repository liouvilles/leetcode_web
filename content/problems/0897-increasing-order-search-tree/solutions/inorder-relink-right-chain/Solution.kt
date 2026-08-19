class Solution {
    private lateinit var tail:TreeNode;
    fun increasingBST(root:TreeNode?):TreeNode?{
        val dummy=TreeNode(0);
        tail=dummy;
        inorder(root);
        return dummy.right
    };
    private fun inorder(node:TreeNode?){
        if(node==null)return;
        inorder(node.left);
        node.left=null;
        tail.right=node;
        tail=node;
        inorder(node.right)
    }
}
