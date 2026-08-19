class Solution {
    public long maximumScoreAfterOperations(int[][] edges,int[] values){
        int n=values.length;
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] parent=new int[n],order=new int[n];
        Arrays.fill(parent,-1);
        parent[0]=0;
        int size=0;
        ArrayDeque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int node=stack.pop();
            order[size++]=node;
            for(int next:graph[node])if(parent[next]==-1){
                parent[next]=node;
                stack.push(next);
            }
        }
        long total=0;
        for(int value:values)total+=value;
        long[] keep=new long[n];
        for(int index=n-1;index>=0;index--){
            int node=order[index];
            long children=0;
            boolean leaf=true;
            for(int next:graph[node])if(parent[next]==node){
                leaf=false;
                children+=keep[next];
            }
            keep[node]=leaf?values[node]:Math.min((long)values[node],children);
        }
        return total-keep[0];
    }
}
