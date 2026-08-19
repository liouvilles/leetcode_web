class Solution {
    private var index=0;
    fun bstFromPreorder(preorder:IntArray):TreeNode?{
        index=0;
        return build(preorder,Int.MAX_VALUE)
    };
    private fun build(preorder:IntArray,bound:Int):TreeNode?{
        if(index==preorder.size||preorder[index]>bound)return null;
        val root=TreeNode(preorder[index++]);
        root.left=build(preorder,root.`val`);
        root.right=build(preorder,bound);
        return root
    }
}
