class Solution {
    public int minScore(int n,int[][] roads){
        List<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)graph[i]=new ArrayList<>();
        for(int[] road:roads){
            graph[road[0]-1].add(new int[]{
                road[1]-1,road[2]
            });
            graph[road[1]-1].add(new int[]{
                road[0]-1,road[2]
            });
        }
        boolean[] visited=new boolean[n];
        Deque<Integer> queue=new ArrayDeque<>();
        queue.offer(0);
        visited[0]=true;
        int answer=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int[] edge:graph[node]){
                answer=Math.min(answer,edge[1]);
                if(!visited[edge[0]]){
                    visited[edge[0]]=true;
                    queue.offer(edge[0]);
                }
            }
        }
        return answer;
    }
}
