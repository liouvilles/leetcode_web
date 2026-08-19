class Solution {
    fun checkTree(root:TreeNode?)=root!!.`val`==root.left!!.`val`+root.right!!.`val`
}
