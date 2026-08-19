class Solution {
    private fun find(node:TreeNode?,target:Int,path:StringBuilder):Boolean{
        if(node==null)return false;
        if(node.`val`==target)return true;
        path.append('L');
        if(find(node.left,target,path))return true;
        path.deleteCharAt(path.lastIndex);
        path.append('R');
        if(find(node.right,target,path))return true;
        path.deleteCharAt(path.lastIndex);
        return false
    };
    fun getDirections(root:TreeNode?,startValue:Int,destValue:Int):String{
        val start=StringBuilder();
        val destination=StringBuilder();
        find(root,startValue,start);
        find(root,destValue,destination);
        var common=0;
        while(common<start.length&&common<destination.length&&start[common]==destination[common])common++;
        return "U".repeat(start.length-common)+destination.substring(common)
    }
}
