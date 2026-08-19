class Solution {
    public int catMouseGame(int[][] graph){
        int n=graph.length;
        int[][][] outcome=new int[n][n][2],degree=new int[n][n][2];
        for(int m=0;m<n;m++)for(int c=1;c<n;c++){
            degree[m][c][0]=graph[m].length;
            int catMoves=0;
            for(int next:graph[c])if(next!=0)catMoves++;
            degree[m][c][1]=catMoves;
        }
        Queue<int[]> queue=new ArrayDeque<>();
        for(int c=1;c<n;c++)for(int turn=0;turn<2;turn++){
            outcome[0][c][turn]=1;
            queue.offer(new int[]{
                0,c,turn,1
            });
        }
        for(int m=1;m<n;m++)for(int turn=0;turn<2;turn++){
            outcome[m][m][turn]=2;
            queue.offer(new int[]{
                m,m,turn,2
            });
        }while(!queue.isEmpty()){
            int[] state=queue.poll();
            int m=state[0],c=state[1],turn=state[2],result=state[3];
            if(turn==0){
                for(int previousCat:graph[c])if(previousCat!=0)propagate(m,previousCat,1,result,outcome,degree,queue);
            }else for(int previousMouse:graph[m])propagate(previousMouse,c,0,result,outcome,degree,queue);
        }
        return outcome[1][2][0];
    }
    private void propagate(int m,int c,int turn,int childResult,int[][][] outcome,int[][][] degree,Queue<int[]> queue){
        if(outcome[m][c][turn]!=0)return;
        int playerWin=turn==0?1:2;
        if(childResult==playerWin){
            outcome[m][c][turn]=childResult;
            queue.offer(new int[]{
                m,c,turn,childResult
            });
        }else if(--degree[m][c][turn]==0){
            int result=turn==0?2:1;
            outcome[m][c][turn]=result;
            queue.offer(new int[]{
                m,c,turn,result
            });
        }
    }
}
