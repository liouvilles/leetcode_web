class Solution {
    fun recoverFromPreorder(traversal:String):TreeNode?{
        val stack=java.util.ArrayDeque<TreeNode>();
        var root:TreeNode?=null;
        var index=0;
        while(index<traversal.length){
            var depth=0;
            while(index<traversal.length&&traversal[index]=='-'){
                depth++;
                index++
            };
            var value=0;
            while(index<traversal.length&&traversal[index].isDigit())value=value*10+traversal[index++].digitToInt();
            while(stack.size>depth)stack.pop();
            val node=TreeNode(value);
            if(stack.isEmpty())root=node else if(stack.peek().left==null)stack.peek().left=node else stack.peek().right=node;
            stack.push(node)
        };
        return root
    }
}
