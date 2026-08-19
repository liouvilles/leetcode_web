class Solution {
    fun binaryTreePaths(root:TreeNode?):List<String>{
        val answer=mutableListOf<String>();
        fun dfs(node:TreeNode?,path:String){
            if(node==null)return;
            val current=if(path.isEmpty())node.`val`.toString() else path+"->"+node.`val`;
            if(node.left==null&&node.right==null)answer.add(current)else{
                dfs(node.left,current);
                dfs(node.right,current)
            }
        };
        dfs(root,"");
        return answer
    }
}
