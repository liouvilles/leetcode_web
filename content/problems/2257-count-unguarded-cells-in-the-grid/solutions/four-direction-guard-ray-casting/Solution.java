class Solution {
    public int countUnguarded(int m,int n,int[][] guards,int[][] walls){
        int[][] state=new int[m][n];
        for(int[] wall:walls)state[wall[0]][wall[1]]=2;
        for(int[] guard:guards)state[guard[0]][guard[1]]=3;
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
        for(int[] guard:guards)for(int[] direction:directions){
            int row=guard[0]+direction[0],column=guard[1]+direction[1];
            while(row>=0&&row<m&&column>=0&&column<n&&state[row][column]!=2&&state[row][column]!=3){
                state[row][column]=1;
                row+=direction[0];
                column+=direction[1];
            }
        }
        int answer=0;
        for(int[] row:state)for(int value:row)if(value==0)answer++;
        return answer;
    }
}
