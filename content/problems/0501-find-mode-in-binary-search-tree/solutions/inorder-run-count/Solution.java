class Solution {
    private Integer previous;
    private int count,best;
    private final List<Integer> modes=new ArrayList<>();
    public int[] findMode(TreeNode root){
        inorder(root);
        return modes.stream().mapToInt(Integer::intValue).toArray();
    }
    private void inorder(TreeNode node){
        if(node==null)return;
        inorder(node.left);
        count=previous!=null&&previous==node.val?count+1:1;
        if(count>best){
            best=count;
            modes.clear();
            modes.add(node.val);
        }else if(count==best)modes.add(node.val);
        previous=node.val;
        inorder(node.right);
    }
}
