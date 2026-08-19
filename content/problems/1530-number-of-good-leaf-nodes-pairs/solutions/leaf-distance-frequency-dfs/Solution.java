class Solution {
    private int distance,answer;
    private int[] dfs(TreeNode node){
        int[] count=new int[distance+1];
        if(node==null)return count;
        if(node.left==null&&node.right==null){
            count[0]=1;
            return count;
        }
        int[] left=dfs(node.left),right=dfs(node.right);
        for(int i=0;i<=distance;i++)for(int j=0;j<=distance;j++)if(i+j+2<=distance)answer+=left[i]*right[j];
        for(int d=0;d<distance;d++)count[d+1]=left[d]+right[d];
        return count;
    }
    public int countPairs(TreeNode root,int distance){
        this.distance=distance;
        dfs(root);
        return answer;
    }
}
