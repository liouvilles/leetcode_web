class Solution {
    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int answer=root.val;
        while(!queue.isEmpty()){
            int size=queue.size();
            answer=queue.peek().val;
            while(size-->0){
                TreeNode node=queue.poll();
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
        }
        return answer;
    }
}
