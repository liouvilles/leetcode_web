class Solution {
    public int secondMinimum(int n,int[][] edges,int time,int change){
        List<Integer>[] graph=new List[n+1];
        for(int i=1;i<=n;i++)graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int infinity=1_000_000;
        int[] first=new int[n+1],second=new int[n+1];
        Arrays.fill(first,infinity);
        Arrays.fill(second,infinity);
        Queue<int[]> queue=new ArrayDeque<>();
        first[1]=0;
        queue.offer(new int[]{
            1,0
        });
        while(!queue.isEmpty()){
            int[] state=queue.poll();
            int node=state[0],distance=state[1];
            for(int next:graph[node]){
                int candidate=distance+1;
                if(candidate<first[next]){
                    second[next]=first[next];
                    first[next]=candidate;
                    queue.offer(new int[]{
                        next,candidate
                    });
                }else if(candidate>first[next]&&candidate<second[next]){
                    second[next]=candidate;
                    queue.offer(new int[]{
                        next,candidate
                    });
                }
            }
        }
        int current=0;
        for(int step=0;step<second[n];step++){
            if((current/change)%2==1)current=(current/change+1)*change;
            current+=time;
        }
        return current;
    }
}
