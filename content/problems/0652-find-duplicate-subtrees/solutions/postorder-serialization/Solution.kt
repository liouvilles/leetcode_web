class Solution {
    private val counts=hashMapOf<String,Int>();
    private val answer=mutableListOf<TreeNode>();
    fun findDuplicateSubtrees(root:TreeNode?):List<TreeNode>{
        serialize(root);
        return answer
    };
    private fun serialize(node:TreeNode?):String{
        if(node==null)return "#";
        val key=node.`val`.toString()+","+serialize(node.left)+","+serialize(node.right);
        val count=(counts[key]?:0)+1;
        counts[key]=count;
        if(count==2)answer.add(node);
        return key
    }
}
