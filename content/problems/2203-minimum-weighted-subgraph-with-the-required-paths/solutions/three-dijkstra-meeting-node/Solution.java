class Solution {
    long[] dijkstra(int start,List<long[]>[] graph){
        long[] distance=new long[graph.length];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[start]=0;
        PriorityQueue<long[]> queue=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        queue.offer(new long[]{
            0,start
        });
        while(!queue.isEmpty()){
            long[] state=queue.poll();
            int node=(int)state[1];
            if(state[0]!=distance[node])continue;
            for(long[] edge:graph[node])if(state[0]+edge[1]<distance[(int)edge[0]]){
                distance[(int)edge[0]]=state[0]+edge[1];
                queue.offer(new long[]{
                    distance[(int)edge[0]],edge[0]
                });
            }
        }
        return distance;
    }
    public long minimumWeight(int n,int[][] edges,int src1,int src2,int dest){
        List<long[]>[] graph=new List[n],reverse=new List[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
            reverse[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(new long[]{
                edge[1],edge[2]
            });
            reverse[edge[1]].add(new long[]{
                edge[0],edge[2]
            });
        }
        long[] first=dijkstra(src1,graph),second=dijkstra(src2,graph),suffix=dijkstra(dest,reverse);
        long answer=Long.MAX_VALUE;
        for(int i=0;i<n;i++)if(first[i]!=Long.MAX_VALUE&&second[i]!=Long.MAX_VALUE&&suffix[i]!=Long.MAX_VALUE)answer=Math.min(answer,first[i]+second[i]+suffix[i]);
        return answer==Long.MAX_VALUE?-1:answer;
    }
}
