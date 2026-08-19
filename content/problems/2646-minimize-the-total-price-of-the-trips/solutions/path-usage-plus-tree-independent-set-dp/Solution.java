class Solution {
    private List<Integer>[] graph;
    private int[] usage,price;
    private boolean addPath(int node,int parent,int target){
        if(node==target){
            usage[node]++;
            return true;
        }
        for(int next:graph[node])if(next!=parent&&addPath(next,node,target)){
            usage[node]++;
            return true;
        }
        return false;
    }
    private long[] solve(int node,int parent){
        long full=(long)usage[node]*price[node],notHalf=full,half=full/2;
        for(int next:graph[node])if(next!=parent){
            long[] child=solve(next,node);
            notHalf+=Math.min(child[0],child[1]);
            half+=child[0];
        }
        return new long[]{
            notHalf,half
        };
    }
    public int minimumTotalPrice(int n,int[][] edges,int[] inputPrice,int[][] trips){
        graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        usage=new int[n];
        price=inputPrice;
        for(int[] trip:trips)addPath(trip[0],-1,trip[1]);
        long[] answer=solve(0,-1);
        return (int)Math.min(answer[0],answer[1]);
    }
}
