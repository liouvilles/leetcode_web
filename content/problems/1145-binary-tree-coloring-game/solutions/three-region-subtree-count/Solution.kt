class Solution {
    private var leftSize=0;
    private var rightSize=0;
    private var target=0;
    fun btreeGameWinningMove(root:TreeNode?,n:Int,x:Int):Boolean{
        target=x;
        size(root);
        val parent=n-1-leftSize-rightSize;
        return maxOf(parent,leftSize,rightSize)>n/2
    };
    private fun size(node:TreeNode?):Int{
        node?:return 0;
        val left=size(node.left);
        val right=size(node.right);
        if(node.`val`==target){
            leftSize=left;
            rightSize=right
        };
        return left+right+1
    }
}
