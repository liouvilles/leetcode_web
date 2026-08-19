class Solution {
    private int answer=0;
    private int[] dfs(TreeNode node){
        if(node==null)return new int[]{
            -1,-1
        };
        int[] left=dfs(node.left),right=dfs(node.right);
        int goLeft=left[1]+1,goRight=right[0]+1;
        answer=Math.max(answer,Math.max(goLeft,goRight));
        return new int[]{
            goLeft,goRight
        };
    }
    public int longestZigZag(TreeNode root){
        dfs(root);
        return answer;
    }
}
