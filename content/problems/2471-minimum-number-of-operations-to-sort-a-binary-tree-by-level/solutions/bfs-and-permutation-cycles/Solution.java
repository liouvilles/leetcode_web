class Solution {
    private int swaps(List<Integer> values){
        int n=values.size();
        Integer[] order=new Integer[n];
        for(int i=0;i<n;i++)order[i]=i;
        Arrays.sort(order,Comparator.comparingInt(values::get));
        boolean[] visited=new boolean[n];
        int answer=0;
        for(int i=0;i<n;i++)if(!visited[i]){
            int length=0,node=i;
            while(!visited[node]){
                visited[node]=true;
                node=order[node];
                length++;
            }
            answer+=length-1;
        }
        return answer;
    }
    public int minimumOperations(TreeNode root){
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        int answer=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> values=new ArrayList<>();
            while(size-->0){
                TreeNode node=queue.poll();
                values.add(node.val);
                if(node.left!=null)queue.offer(node.left);
                if(node.right!=null)queue.offer(node.right);
            }
            answer+=swaps(values);
        }
        return answer;
    }
}
