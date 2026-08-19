class Solution {
    private long[] dijkstra(int source,List<int[]>[] graph){
        long infinity=Long.MAX_VALUE/4;
        long[] distance=new long[graph.length];
        Arrays.fill(distance,infinity);
        distance[source]=0;
        PriorityQueue<long[]> queue=new PriorityQueue<>(Comparator.comparingLong(entry->entry[0]));
        queue.add(new long[]{
            0,source
        });
        while(!queue.isEmpty()){
            long[] current=queue.poll();
            long cost=current[0];
            int node=(int)current[1];
            if(cost!=distance[node])continue;
            for(int[] edge:graph[node]){
                int next=edge[0];
                long candidate=cost+edge[1];
                if(candidate<distance[next]){
                    distance[next]=candidate;
                    queue.add(new long[]{
                        candidate,next
                    });
                }
            }
        }
        return distance;
    }
    public boolean[] findAnswer(int n,int[][] edges){
        List<int[]>[] graph=new List[n];
        for(int node=0;node<n;node++)graph[node]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(new int[]{
                edge[1],edge[2]
            });
            graph[edge[1]].add(new int[]{
                edge[0],edge[2]
            });
        }
        long[] fromStart=dijkstra(0,graph),fromEnd=dijkstra(n-1,graph);
        long shortest=fromStart[n-1];
        boolean[] answer=new boolean[edges.length];
        for(int index=0;index<edges.length;index++){
            int u=edges[index][0],v=edges[index][1],weight=edges[index][2];
            answer[index]=fromStart[u]+weight+fromEnd[v]==shortest||fromStart[v]+weight+fromEnd[u]==shortest;
        }
        return answer;
    }
}
