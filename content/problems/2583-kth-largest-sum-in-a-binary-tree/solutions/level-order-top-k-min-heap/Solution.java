class Solution {
    public long kthLargestLevelSum(TreeNode root,int k){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        PriorityQueue<Long> largest=new PriorityQueue<>();
        while(!queue.isEmpty()){
            long sum=0;
            for(int size=queue.size();size>0;size--){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
            largest.add(sum);
            if(largest.size()>k)largest.poll();
        }
        return largest.size()<k?-1L:largest.peek();
    }
}
