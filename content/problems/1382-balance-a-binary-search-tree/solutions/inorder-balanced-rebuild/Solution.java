class Solution {
    private final List<Integer> values=new ArrayList<>();
    private void inorder(TreeNode node){
        if(node==null)return;
        inorder(node.left);
        values.add(node.val);
        inorder(node.right);
    }
    private TreeNode build(int left,int right){
        if(left>right)return null;
        int middle=left+(right-left)/2;
        TreeNode root=new TreeNode(values.get(middle));
        root.left=build(left,middle-1);
        root.right=build(middle+1,right);
        return root;
    }
    public TreeNode balanceBST(TreeNode root){
        inorder(root);
        return build(0,values.size()-1);
    }
}
