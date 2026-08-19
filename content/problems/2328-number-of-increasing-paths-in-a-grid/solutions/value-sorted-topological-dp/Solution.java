class Solution {
    public int countPaths(int[][] grid){
        long mod=1_000_000_007L;
        int rows=grid.length,columns=grid[0].length,total=rows*columns;
        Integer[] order=new Integer[total];
        for(int i=0;i<total;i++)order[i]=i;
        Arrays.sort(order,Comparator.comparingInt(i->grid[i/columns][i%columns]));
        long[] dp=new long[total];
        Arrays.fill(dp,1);
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
        long answer=0;
        for(int index:order){
            int row=index/columns,column=index%columns;
            for(int[] direction:directions){
                int r=row+direction[0],c=column+direction[1];
                if(r>=0&&r<rows&&c>=0&&c<columns&&grid[r][c]<grid[row][column])dp[index]=(dp[index]+dp[r*columns+c])%mod;
            }
            answer=(answer+dp[index])%mod;
        }
        return (int)answer;
    }
}
