class Solution {
    private String best;
    public String smallestFromLeaf(TreeNode root){
        best=null;
        dfs(root,new StringBuilder());
        return best;
    }
    private void dfs(TreeNode node,StringBuilder path){
        if(node==null)return;
        path.append((char)('a'+node.val));
        if(node.left==null&&node.right==null){
            String candidate=new StringBuilder(path).reverse().toString();
            if(best==null||candidate.compareTo(best)<0)best=candidate;
        }else{
            dfs(node.left,path);
            dfs(node.right,path);
        }
        path.deleteCharAt(path.length()-1);
    }
}
