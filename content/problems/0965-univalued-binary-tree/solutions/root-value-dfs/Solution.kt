class Solution {
    fun isUnivalTree(root:TreeNode):Boolean=check(root,root.`val`);
    private fun check(node:TreeNode?,target:Int):Boolean=node==null||node.`val`==target&&check(node.left,target)&&check(node.right,target)
}
