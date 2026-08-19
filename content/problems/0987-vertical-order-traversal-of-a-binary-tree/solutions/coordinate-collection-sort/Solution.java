class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<int[]> nodes=new ArrayList<>();
        collect(root,0,0,nodes);
        nodes.sort(Comparator.<int[]>comparingInt(a->a[0]).thenComparingInt(a->a[1]).thenComparingInt(a->a[2]));
        List<List<Integer>> answer=new ArrayList<>();
        int column=Integer.MIN_VALUE;
        for(int[] node:nodes){
            if(node[0]!=column){
                column=node[0];
                answer.add(new ArrayList<>());
            }
            answer.get(answer.size()-1).add(node[2]);
        }
        return answer;
    }
    private void collect(TreeNode node,int row,int column,List<int[]> nodes){
        if(node==null)return;
        nodes.add(new int[]{
            column,row,node.val
        });
        collect(node.left,row+1,column-1,nodes);
        collect(node.right,row+1,column+1,nodes);
    }
}
