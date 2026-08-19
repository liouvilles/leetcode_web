class Solution {
    fun insertIntoMaxTree(root:TreeNode?,value:Int):TreeNode{
        root?:return TreeNode(value);
        if(value>root.`val`){
            val node=TreeNode(value);
            node.left=root;
            return node
        };
        root.right=insertIntoMaxTree(root.right,value);
        return root
    }
}
