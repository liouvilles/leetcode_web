class Solution {
    public int networkBecomesIdle(int[][] edges,int[] patience){
        int n=patience.length;
        List<Integer>[] graph=new List[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] distance=new int[n];
        Arrays.fill(distance,-1);
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(0);
        distance[0]=0;
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int next:graph[node])if(distance[next]<0){
                distance[next]=distance[node]+1;
                queue.offer(next);
            }
        }
        int answer=0;
        for(int node=1;node<n;node++){
            int roundTrip=2*distance[node];
            int lastSend=(roundTrip-1)/patience[node]*patience[node];
            answer=Math.max(answer,lastSend+roundTrip+1);
        }
        return answer;
    }
}
