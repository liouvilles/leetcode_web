class Solution {
    public int largestIsland(int[][] grid){
        int n=grid.length,id=2,answer=0;
        Map<Integer,Integer> area=new HashMap<>();
        for(int r=0;r<n;r++)for(int c=0;c<n;c++)if(grid[r][c]==1){
            int size=paint(grid,r,c,id);
            area.put(id,size);
            answer=Math.max(answer,size);
            id++;
        }
        int[] directions={
            -1,0,1,0,-1
        };
        for(int r=0;r<n;r++)for(int c=0;c<n;c++)if(grid[r][c]==0){
            int size=1;
            Set<Integer> seen=new HashSet<>();
            for(int d=0;d<4;d++){
                int nr=r+directions[d],nc=c+directions[d+1];
                if(nr>=0&&nr<n&&nc>=0&&nc<n&&grid[nr][nc]>1&&seen.add(grid[nr][nc]))size+=area.get(grid[nr][nc]);
            }
            answer=Math.max(answer,size);
        }
        return answer;
    }
    private int paint(int[][] grid,int r,int c,int id){
        if(r<0||r>=grid.length||c<0||c>=grid.length||grid[r][c]!=1)return 0;
        grid[r][c]=id;
        return 1+paint(grid,r+1,c,id)+paint(grid,r-1,c,id)+paint(grid,r,c+1,id)+paint(grid,r,c-1,id);
    }
}
