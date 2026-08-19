class Solution {
    private List<Integer>[] graph;
    private int[] amount;
    private int path(int node,int parent){
        boolean leaf=node!=0&&graph[node].size()==1;
        if(leaf)return amount[node];
        int best=Integer.MIN_VALUE;
        for(int next:graph[node])if(next!=parent)best=Math.max(best,path(next,node));
        return amount[node]+best;
    }
    public int mostProfitablePath(int[][] edges,int bob,int[] amount){
        int n=amount.length;
        this.amount=amount;
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] parent=new int[n],depth=new int[n];
        Arrays.fill(parent,-2);
        parent[0]=-1;
        Deque<Integer> queue=new ArrayDeque<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int next:graph[node])if(parent[next]==-2){
                parent[next]=node;
                depth[next]=depth[node]+1;
                queue.offer(next);
            }
        }
        for(int node=bob,time=0;node!=-1;node=parent[node],time++){
            if(time<depth[node])amount[node]=0;
            else if(time==depth[node])amount[node]/=2;
        }
        return path(0,-1);
    }
}
