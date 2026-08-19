class Solution {
    fun getTargetCopy(original:TreeNode?,cloned:TreeNode?,target:TreeNode?):TreeNode?{
        if(original==null)return null;
        if(original.`val`==target!!.`val`)return cloned;
        val left=getTargetCopy(original.left,cloned!!.left,target);
        return left?:getTargetCopy(original.right,cloned.right,target)
    }
}
