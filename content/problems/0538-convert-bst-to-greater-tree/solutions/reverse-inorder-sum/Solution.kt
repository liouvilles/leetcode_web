class Solution {
    private var sum=0;
    fun convertBST(root:TreeNode?):TreeNode?{
        fun traverse(node:TreeNode?){
            if(node==null)return;
            traverse(node.right);
            sum+=node.`val`;
            node.`val`=sum;
            traverse(node.left)
        };
        traverse(root);
        return root
    }
}
