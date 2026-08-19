class Solution {
    private int[][] grid;
    private int rows,columns;
    private final int[][] directions={
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
    public int containVirus(int[][] isInfected){
        grid=isInfected;
        rows=grid.length;
        columns=grid[0].length;
        int total=0;
        while(true){
            boolean[][] seen=new boolean[rows][columns];
            List<List<Integer>> regions=new ArrayList<>();
            List<Set<Integer>> frontiers=new ArrayList<>();
            List<Integer> walls=new ArrayList<>();
            for(int r=0;r<rows;r++)for(int c=0;c<columns;c++)if(grid[r][c]==1&&!seen[r][c]){
                List<Integer> region=new ArrayList<>();
                Set<Integer> frontier=new HashSet<>();
                int[] count={
                    0
                };
                dfs(r,c,seen,region,frontier,count);
                regions.add(region);
                frontiers.add(frontier);
                walls.add(count[0]);
            }
            if(regions.isEmpty())break;
            int chosen=0;
            for(int i=1;i<frontiers.size();i++)if(frontiers.get(i).size()>frontiers.get(chosen).size())chosen=i;
            if(frontiers.get(chosen).isEmpty())break;
            total+=walls.get(chosen);
            for(int code:regions.get(chosen))grid[code/columns][code%columns]=-1;
            for(int i=0;i<frontiers.size();i++)if(i!=chosen)for(int code:frontiers.get(i))grid[code/columns][code%columns]=1;
        }
        return total;
    }
    private void dfs(int row,int column,boolean[][] seen,List<Integer> region,Set<Integer> frontier,int[] walls){
        seen[row][column]=true;
        region.add(row*columns+column);
        for(int[] d:directions){
            int r=row+d[0],c=column+d[1];
            if(r<0||r>=rows||c<0||c>=columns)continue;
            if(grid[r][c]==0){
                frontier.add(r*columns+c);
                walls[0]++;
            }else if(grid[r][c]==1&&!seen[r][c])dfs(r,c,seen,region,frontier,walls);
        }
    }
}
