class Solution {
    public int shortestPathLength(int[][] graph){
        int n=graph.length,target=(1<<n)-1;
        boolean[][] seen=new boolean[n][1<<n];
        Queue<int[]> queue=new ArrayDeque<>();
        for(int node=0;node<n;node++){
            queue.offer(new int[]{
                node,1<<node,0
            });
            seen[node][1<<node]=true;
        }while(!queue.isEmpty()){
            int[] state=queue.poll();
            if(state[1]==target)return state[2];
            for(int next:graph[state[0]]){
                int mask=state[1]|1<<next;
                if(!seen[next][mask]){
                    seen[next][mask]=true;
                    queue.offer(new int[]{
                        next,mask,state[2]+1
                    });
                }
            }
        }
        return -1;
    }
}
