class Solution {
    public TreeNode replaceValueInTree(TreeNode root){
        root.val=0;
        List<TreeNode> level=new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()){
            int nextTotal=0;
            for(TreeNode node:level){
                if(node.left!=null)nextTotal+=node.left.val;
                if(node.right!=null)nextTotal+=node.right.val;
            }
            List<TreeNode> nextLevel=new ArrayList<>();
            for(TreeNode node:level){
                int siblingSum=(node.left==null?0:node.left.val)+(node.right==null?0:node.right.val);
                if(node.left!=null){
                    node.left.val=nextTotal-siblingSum;
                    nextLevel.add(node.left);
                }
                if(node.right!=null){
                    node.right.val=nextTotal-siblingSum;
                    nextLevel.add(node.right);
                }
            }
            level=nextLevel;
        }
        return root;
    }
}
