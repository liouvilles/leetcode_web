class Solution {
    fun findTilt(root:TreeNode?):Int{
        var tilt=0;
        fun sum(node:TreeNode?):Int{
            if(node==null)return 0;
            val left=sum(node.left);
            val right=sum(node.right);
            tilt+=kotlin.math.abs(left-right);
            return left+right+node.`val`
        };
        sum(root);
        return tilt
    }
}
