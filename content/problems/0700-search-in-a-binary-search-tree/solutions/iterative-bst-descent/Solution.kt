class Solution {
    fun searchBST(root:TreeNode?,`val`:Int):TreeNode?{
        var current=root;
        while(current!=null&&current.`val`!=`val`)current=if(`val`<current.`val`)current.left else current.right;
        return current
    }
}
