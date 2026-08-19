class Solution {
    private final Map<Integer,Integer> height=new HashMap<>(),answer=new HashMap<>();
    private int measure(TreeNode node){
        if(node==null)return 0;
        int value=1+Math.max(measure(node.left),measure(node.right));
        height.put(node.val,value);
        return value;
    }
    private void reroot(TreeNode node,int depth,int rest){
        if(node==null)return;
        answer.put(node.val,rest);
        reroot(node.left,depth+1,Math.max(rest,depth+(node.right==null?0:height.get(node.right.val))));
        reroot(node.right,depth+1,Math.max(rest,depth+(node.left==null?0:height.get(node.left.val))));
    }
    public int[] treeQueries(TreeNode root,int[] queries){
        measure(root);
        reroot(root,0,0);
        int[] result=new int[queries.length];
        for(int i=0;i<queries.length;i++)result[i]=answer.get(queries[i]);
        return result;
    }
}
