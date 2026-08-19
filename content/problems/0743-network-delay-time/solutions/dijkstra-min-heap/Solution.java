class Solution {
    public int networkDelayTime(int[][] times,int n,int k){
        List<int[]>[] graph=new List[n+1];
        for(int i=1;i<=n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:times)graph[edge[0]].add(new int[]{
            edge[1],edge[2]
        });
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k]=0;
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(item->item[0]));
        heap.offer(new int[]{
            0,k
        });
        while(!heap.isEmpty()){
            int[] state=heap.poll();
            if(state[0]!=distance[state[1]])continue;
            for(int[] edge:graph[state[1]]){
                int next=state[0]+edge[1];
                if(next<distance[edge[0]]){
                    distance[edge[0]]=next;
                    heap.offer(new int[]{
                        next,edge[0]
                    });
                }
            }
        }
        int answer=0;
        for(int node=1;node<=n;node++){
            if(distance[node]==Integer.MAX_VALUE)return -1;
            answer=Math.max(answer,distance[node]);
        }
        return answer;
    }
}
