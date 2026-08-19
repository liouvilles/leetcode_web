class Solution {
    private final Map<TreeNode,TreeNode> parent=new HashMap<>();
    private TreeNode actualTarget;
    public List<Integer> distanceK(TreeNode root,TreeNode target,int k){
        build(root,null,target.val);
        Queue<TreeNode> queue=new ArrayDeque<>();
        Set<TreeNode> seen=new HashSet<>();
        queue.offer(actualTarget);
        seen.add(actualTarget);
        for(int distance=0;distance<k;distance++)for(int size=queue.size();size>0;size--){
            TreeNode node=queue.poll();
            add(node.left,seen,queue);
            add(node.right,seen,queue);
            add(parent.get(node),seen,queue);
        }
        List<Integer> answer=new ArrayList<>();
        while(!queue.isEmpty())answer.add(queue.poll().val);
        return answer;
    }
    private void build(TreeNode node,TreeNode p,int targetValue){
        if(node==null)return;
        parent.put(node,p);
        if(node.val==targetValue)actualTarget=node;
        build(node.left,node,targetValue);
        build(node.right,node,targetValue);
    }
    private void add(TreeNode node,Set<TreeNode> seen,Queue<TreeNode> queue){
        if(node!=null&&seen.add(node))queue.offer(node);
    }
}
