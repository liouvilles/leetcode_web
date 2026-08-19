class Solution {
    public TreeNode recoverFromPreorder(String traversal){
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode root=null;
        int index=0;
        while(index<traversal.length()){
            int depth=0;
            while(index<traversal.length()&&traversal.charAt(index)=='-'){
                depth++;
                index++;
            }
            int value=0;
            while(index<traversal.length()&&Character.isDigit(traversal.charAt(index)))value=value*10+traversal.charAt(index++)-'0';
            while(stack.size()>depth)stack.pop();
            TreeNode node=new TreeNode(value);
            if(stack.isEmpty())root=node;
            else if(stack.peek().left==null)stack.peek().left=node;
            else stack.peek().right=node;
            stack.push(node);
        }
        return root;
    }
}
