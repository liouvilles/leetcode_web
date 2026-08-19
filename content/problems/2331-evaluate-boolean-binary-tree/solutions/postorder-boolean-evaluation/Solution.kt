class Solution {
    fun evaluateTree(root:TreeNode?):Boolean{
        root!!;
        if(root.left==null)return root.`val`==1;
        val left=evaluateTree(root.left);
        val right=evaluateTree(root.right);
        return if(root.`val`==2)left||right else left&&right
    }
}
