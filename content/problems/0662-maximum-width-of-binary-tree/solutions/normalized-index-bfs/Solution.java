class Solution {
    private static class State{
        TreeNode node;
        long index;
        State(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root){
        Queue<State> queue=new ArrayDeque<>();
        queue.offer(new State(root,0));
        long best=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            long base=queue.peek().index,first=0,last=0;
            for(int i=0;i<size;i++){
                State state=queue.poll();
                long index=state.index-base;
                if(i==0)first=index;
                if(i==size-1)last=index;
                if(state.node.left!=null)queue.offer(new State(state.node.left,index*2));
                if(state.node.right!=null)queue.offer(new State(state.node.right,index*2+1));
            }
            best=Math.max(best,last-first+1);
        }
        return(int)best;
    }
}
