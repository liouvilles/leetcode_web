class Solution {
    private lateinit var preorder:IntArray;
    private lateinit var postIndex:Map<Int,Int>;
    fun constructFromPrePost(preorder:IntArray,postorder:IntArray):TreeNode?{
        this.preorder=preorder;
        postIndex=postorder.indices.associateBy{
            postorder[it]
        };
        return build(0,preorder.lastIndex,0)
    };
    private fun build(preLeft:Int,preRight:Int,postLeft:Int):TreeNode?{
        if(preLeft>preRight)return null;
        val root=TreeNode(preorder[preLeft]);
        if(preLeft==preRight)return root;
        val leftSize=postIndex[preorder[preLeft+1]]!!-postLeft+1;
        root.left=build(preLeft+1,preLeft+leftSize,postLeft);
        root.right=build(preLeft+leftSize+1,preRight,postLeft+leftSize);
        return root
    }
}
