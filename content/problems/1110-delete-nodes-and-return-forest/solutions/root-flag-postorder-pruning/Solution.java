class Solution {
    private Set<Integer> deleted;
    private List<TreeNode> forest;
    public List<TreeNode> delNodes(TreeNode root,int[] toDelete){
        deleted=new HashSet<>();
        for(int value:toDelete)deleted.add(value);
        forest=new ArrayList<>();
        dfs(root,true);
        return forest;
    }
    private TreeNode dfs(TreeNode node,boolean isRoot){
        if(node==null)return null;
        boolean remove=deleted.contains(node.val);
        if(isRoot&&!remove)forest.add(node);
        node.left=dfs(node.left,remove);
        node.right=dfs(node.right,remove);
        return remove?null:node;
    }
}
