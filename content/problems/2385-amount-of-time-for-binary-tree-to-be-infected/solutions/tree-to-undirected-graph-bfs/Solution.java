class Solution {
    Map<Integer,List<Integer>> graph=new HashMap<>();
    private void build(TreeNode node){
        if(node==null)return;
        graph.computeIfAbsent(node.val,key->new ArrayList<>());
        if(node.left!=null){
            graph.get(node.val).add(node.left.val);
            graph.computeIfAbsent(node.left.val,key->new ArrayList<>()).add(node.val);
            build(node.left);
        }
        if(node.right!=null){
            graph.get(node.val).add(node.right.val);
            graph.computeIfAbsent(node.right.val,key->new ArrayList<>()).add(node.val);
            build(node.right);
        }
    }
    public int amountOfTime(TreeNode root,int start){
        build(root);
        Queue<Integer> queue=new ArrayDeque<>();
        Set<Integer> seen=new HashSet<>();
        queue.add(start);
        seen.add(start);
        int minutes=-1;
        while(!queue.isEmpty()){
            minutes++;
            for(int size=queue.size();size>0;size--){
                int node=queue.poll();
                for(int next:graph.get(node))if(seen.add(next))queue.add(next);
            }
        }
        return minutes;
    }
}
