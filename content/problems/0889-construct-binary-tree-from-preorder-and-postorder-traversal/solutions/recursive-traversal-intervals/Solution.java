class Solution {
    private int[] preorder;
    private Map<Integer,Integer> postIndex=new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder,int[] postorder){
        this.preorder=preorder;
        for(int i=0;i<postorder.length;i++)postIndex.put(postorder[i],i);
        return build(0,preorder.length-1,0);
    }
    private TreeNode build(int preLeft,int preRight,int postLeft){
        if(preLeft>preRight)return null;
        TreeNode root=new TreeNode(preorder[preLeft]);
        if(preLeft==preRight)return root;
        int leftSize=postIndex.get(preorder[preLeft+1])-postLeft+1;
        root.left=build(preLeft+1,preLeft+leftSize,postLeft);
        root.right=build(preLeft+leftSize+1,preRight,postLeft+leftSize);
        return root;
    }
}
