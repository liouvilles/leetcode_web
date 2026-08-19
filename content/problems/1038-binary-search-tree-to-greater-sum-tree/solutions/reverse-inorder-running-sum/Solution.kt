class Solution {
    private var running=0;
    fun bstToGst(root:TreeNode?):TreeNode?{
        running=0;
        traverse(root);
        return root
    };
    private fun traverse(node:TreeNode?){
        node?:return;
        traverse(node.right);
        running+=node.`val`;
        node.`val`=running;
        traverse(node.left)
    }
}
