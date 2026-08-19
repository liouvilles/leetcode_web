class Solution {
    public int[] shortestAlternatingPaths(int n,int[][] redEdges,int[][] blueEdges){
        List<Integer>[][] graph=new List[2][n];
        for(int color=0;color<2;color++)for(int i=0;i<n;i++)graph[color][i]=new ArrayList<>();
        for(int[] edge:redEdges)graph[0][edge[0]].add(edge[1]);
        for(int[] edge:blueEdges)graph[1][edge[0]].add(edge[1]);
        int[][] distance=new int[n][2];
        for(int[] row:distance)Arrays.fill(row,-1);
        Queue<int[]> queue=new ArrayDeque<>();
        for(int color=0;color<2;color++){
            distance[0][color]=0;
            queue.offer(new int[]{
                0,color
            });
        }while(!queue.isEmpty()){
            int[] state=queue.poll();
            int nextColor=1-state[1];
            for(int next:graph[nextColor][state[0]])if(distance[next][nextColor]<0){
                distance[next][nextColor]=distance[state[0]][state[1]]+1;
                queue.offer(new int[]{
                    next,nextColor
                });
            }
        }
        int[] answer=new int[n];
        for(int i=0;i<n;i++)answer[i]=distance[i][0]<0?distance[i][1]:distance[i][1]<0?distance[i][0]:Math.min(distance[i][0],distance[i][1]);
        return answer;
    }
}
