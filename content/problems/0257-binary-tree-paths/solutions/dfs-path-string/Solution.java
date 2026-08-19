class Solution {
    public List<String> binaryTreePaths(TreeNode root){
        List<String> answer=new ArrayList<>();
        dfs(root,"",answer);
        return answer;
    }
    private void dfs(TreeNode node,String path,List<String> answer){
        if(node==null)return;
        String current=path.isEmpty()?String.valueOf(node.val):path+"->"+node.val;
        if(node.left==null&&node.right==null)answer.add(current);
        else{
            dfs(node.left,current,answer);
            dfs(node.right,current,answer);
        }
    }
}
