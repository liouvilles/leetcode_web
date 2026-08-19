class Solution {
    private int index;
    private List<Integer> flips;
    public List<Integer> flipMatchVoyage(TreeNode root,int[] voyage){
        index=0;
        flips=new ArrayList<>();
        if(!dfs(root,voyage))return Arrays.asList(-1);
        return flips;
    }
    private boolean dfs(TreeNode node,int[] voyage){
        if(node==null)return true;
        if(index>=voyage.length||node.val!=voyage[index++])return false;
        if(node.left!=null&&index<voyage.length&&node.left.val!=voyage[index]){
            flips.add(node.val);
            return dfs(node.right,voyage)&&dfs(node.left,voyage);
        }
        return dfs(node.left,voyage)&&dfs(node.right,voyage);
    }
}
