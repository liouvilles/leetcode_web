class Solution {
    public int[] minimumTime(int n,int[][] edges,int[] disappear){
        List<int[]>[] graph=new ArrayList[n];
        for(int node=0;node<n;node++)graph[node]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(new int[]{
                edge[1],edge[2]
            });
            graph[edge[1]].add(new int[]{
                edge[0],edge[2]
            });
        }
        long[] distance=new long[n];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[0]=0;
        PriorityQueue<long[]> queue=new PriorityQueue<>(Comparator.comparingLong(state->state[0]));
        queue.add(new long[]{
            0,0
        });
        while(!queue.isEmpty()){
            long[] state=queue.poll();
            long time=state[0];
            int node=(int)state[1];
            if(time!=distance[node])continue;
            for(int[] edge:graph[node]){
                int next=edge[0];
                long candidate=time+edge[1];
                if(candidate<distance[next]&&candidate<disappear[next]){
                    distance[next]=candidate;
                    queue.add(new long[]{
                        candidate,next
                    });
                }
            }
        }
        int[] answer=new int[n];
        for(int node=0;node<n;node++)answer[node]=distance[node]==Long.MAX_VALUE?-1:(int)distance[node];
        return answer;
    }
}
