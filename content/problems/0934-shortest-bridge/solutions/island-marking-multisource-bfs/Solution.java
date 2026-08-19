class Solution {
    public int shortestBridge(int[][] grid){
        int n=grid.length;
        Deque<int[]> flood=new ArrayDeque<>(),frontier=new ArrayDeque<>();
        outer:for(int r=0;r<n;r++)for(int c=0;c<n;c++)if(grid[r][c]==1){
            flood.offer(new int[]{
                r,c
            });
            grid[r][c]=2;
            break outer;
        }
        int[][] directions={
            {
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        while(!flood.isEmpty()){
            int[] cell=flood.poll();
            frontier.offer(cell);
            for(int[] d:directions){
                int r=cell[0]+d[0],c=cell[1]+d[1];
                if(r>=0&&r<n&&c>=0&&c<n&&grid[r][c]==1){
                    grid[r][c]=2;
                    flood.offer(new int[]{
                        r,c
                    });
                }
            }
        }
        int distance=0;
        while(!frontier.isEmpty()){
            for(int size=frontier.size();size>0;size--){
                int[] cell=frontier.poll();
                for(int[] d:directions){
                    int r=cell[0]+d[0],c=cell[1]+d[1];
                    if(r<0||r>=n||c<0||c>=n||grid[r][c]==2)continue;
                    if(grid[r][c]==1)return distance;
                    grid[r][c]=2;
                    frontier.offer(new int[]{
                        r,c
                    });
                }
            }
            distance++;
        }
        return -1;
    }
}
