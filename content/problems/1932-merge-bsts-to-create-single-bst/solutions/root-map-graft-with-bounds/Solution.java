class Solution {
    Map<Integer,TreeNode> roots;
    private boolean validate(TreeNode node,long low,long high){
        if(node==null)return true;
        if(node.val<=low||node.val>=high)return false;
        if(node.left==null&&node.right==null){
            TreeNode merged=roots.get(node.val);
            if(merged!=null&&merged!=node){
                roots.remove(node.val);
                node.left=merged.left;
                node.right=merged.right;
            }
        }
        return validate(node.left,low,node.val)&&validate(node.right,node.val,high);
    }
    public TreeNode canMerge(List<TreeNode> trees){
        roots=new HashMap<>();
        Set<Integer> leaves=new HashSet<>();
        for(TreeNode tree:trees){
            roots.put(tree.val,tree);
            if(tree.left!=null)leaves.add(tree.left.val);
            if(tree.right!=null)leaves.add(tree.right.val);
        }
        TreeNode root=null;
        for(TreeNode tree:trees)if(!leaves.contains(tree.val)){
            if(root!=null)return null;
            root=tree;
        }
        if(root==null||!validate(root,Long.MIN_VALUE,Long.MAX_VALUE)||roots.size()!=1)return null;
        return root;
    }
}
