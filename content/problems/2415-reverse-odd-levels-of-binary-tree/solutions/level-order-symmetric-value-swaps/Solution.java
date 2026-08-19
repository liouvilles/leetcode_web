class Solution {
    public TreeNode reverseOddLevels(TreeNode root){
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            List<TreeNode> nodes=new ArrayList<>();
            for(int size=queue.size();size>0;size--){
                TreeNode node=queue.poll();
                nodes.add(node);
                if(node.left!=null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if(level%2==1)for(int left=0,right=nodes.size()-1;left<right;left++,right--){
                int value=nodes.get(left).val;
                nodes.get(left).val=nodes.get(right).val;
                nodes.get(right).val=value;
            }
            level++;
        }
        return root;
    }
}
