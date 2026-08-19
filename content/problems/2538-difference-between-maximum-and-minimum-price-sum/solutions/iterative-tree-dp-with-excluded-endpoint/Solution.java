class Solution {
    public long maxOutput(int n,int[][] edges,int[] price){
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] parent=new int[n],order=new int[n];
        Arrays.fill(parent,-2);
        parent[0]=-1;
        int size=1;
        for(int index=0;index<size;index++){
            int node=order[index];
            for(int next:graph[node])if(parent[next]==-2){
                parent[next]=node;
                order[size++]=next;
            }
        }
        long[] full=new long[n],excluded=new long[n];
        long answer=0;
        for(int index=n-1;index>=0;index--){
            int node=order[index];
            long bestFull=price[node],bestExcluded=0;
            for(int child:graph[node])if(parent[child]==node){
                answer=Math.max(answer,Math.max(bestFull+excluded[child],bestExcluded+full[child]));
                bestFull=Math.max(bestFull,price[node]+full[child]);
                bestExcluded=Math.max(bestExcluded,price[node]+excluded[child]);
            }
            full[node]=bestFull;
            excluded[node]=bestExcluded;
        }
        return answer;
    }
}
