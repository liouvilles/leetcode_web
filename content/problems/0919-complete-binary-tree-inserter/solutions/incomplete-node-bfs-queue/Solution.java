class CBTInserter {
    private final TreeNode root;
    private final Queue<TreeNode> candidates=new ArrayDeque<>();
    public CBTInserter(TreeNode root){
        this.root=root;
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node.left==null||node.right==null)candidates.offer(node);
            if(node.left!=null)queue.offer(node.left);
            if(node.right!=null)queue.offer(node.right);
        }
    }
    public int insert(int val){
        TreeNode parent=candidates.peek(),node=new TreeNode(val);
        if(parent.left==null)parent.left=node;
        else{
            parent.right=node;
            candidates.poll();
        }
        candidates.offer(node);
        return parent.val;
    }
    public TreeNode get_root(){
        return root;
    }
}
