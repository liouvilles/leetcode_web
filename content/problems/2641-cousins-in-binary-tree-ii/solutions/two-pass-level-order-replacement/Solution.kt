class Solution {
    fun replaceValueInTree(root:TreeNode?):TreeNode?{
        if(root==null)return null;
        root.`val`=0;
        var level=listOf(root);
        while(level.isNotEmpty()){
            var nextTotal=0;
            for(node in level){
                nextTotal+=node.left?.`val`?:0;
                nextTotal+=node.right?.`val`?:0
            };
            val nextLevel=mutableListOf<TreeNode>();
            for(node in level){
                val siblingSum=(node.left?.`val`?:0)+(node.right?.`val`?:0);
                node.left?.let{
                    it.`val`=nextTotal-siblingSum;
                    nextLevel.add(it)
                };
                node.right?.let{
                    it.`val`=nextTotal-siblingSum;
                    nextLevel.add(it)
                }
            };
            level=nextLevel
        };
        return root
    }
}
