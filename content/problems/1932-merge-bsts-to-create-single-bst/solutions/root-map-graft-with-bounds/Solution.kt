class Solution {
    private lateinit var roots:MutableMap<Int,TreeNode>;
    private fun validate(node:TreeNode?,low:Long,high:Long):Boolean{
        if(node==null)return true;
        if(node.`val`<=low||node.`val`>=high)return false;
        if(node.left==null&&node.right==null){
            val merged=roots[node.`val`];
            if(merged!=null&&merged!==node){
                roots.remove(node.`val`);
                node.left=merged.left;
                node.right=merged.right
            }
        };
        return validate(node.left,low,node.`val`.toLong())&&validate(node.right,node.`val`.toLong(),high)
    };
    fun canMerge(trees:List<TreeNode?>):TreeNode?{
        roots=HashMap();
        val leaves=HashSet<Int>();
        for(treeValue in trees){
            val tree=treeValue!!;
            roots[tree.`val`]=tree;
            tree.left?.let{
                leaves.add(it.`val`)
            };
            tree.right?.let{
                leaves.add(it.`val`)
            }
        };
        var root:TreeNode?=null;
        for(treeValue in trees){
            val tree=treeValue!!;
            if(tree.`val` !in leaves){
                if(root!=null)return null;
                root=tree
            }
        };
        if(root==null||!validate(root,Long.MIN_VALUE,Long.MAX_VALUE)||roots.size!=1)return null;
        return root
    }
}
