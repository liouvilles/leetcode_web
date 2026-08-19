class Solution {
    private String[] grid;
    private int rows,cols,food,catJump,mouseJump,cells;
    private byte[] memo;
    private boolean dfs(int turn,int mouse,int cat){
        if(cat==mouse||cat==food||turn>=1000)return false;
        if(mouse==food)return true;
        int key=(turn*cells+mouse)*cells+cat;
        if(memo[key]!=0)return memo[key]==1;
        boolean mouseTurn=turn%2==0;
        int position=mouseTurn?mouse:cat,jump=mouseTurn?mouseJump:catJump,row=position/cols,col=position%cols;
        int[][] directions={
            {
                0,0
            },{
                1,0
            },{
                -1,0
            },{
                0,1
            },{
                0,-1
            }
        };
        boolean result=mouseTurn?false:true;
        outer:for(int[] direction:directions){
            int limit=direction[0]==0&&direction[1]==0?0:jump;
            for(int step=0;step<=limit;step++){
                int nextRow=row+direction[0]*step,nextCol=col+direction[1]*step;
                if(nextRow<0||nextRow>=rows||nextCol<0||nextCol>=cols||grid[nextRow].charAt(nextCol)=='#')break;
                int next=nextRow*cols+nextCol;
                boolean child=mouseTurn?dfs(turn+1,next,cat):dfs(turn+1,mouse,next);
                if(mouseTurn&&child){
                    result=true;
                    break outer;
                }
                if(!mouseTurn&&!child){
                    result=false;
                    break outer;
                }
            }
        }
        memo[key]=(byte)(result?1:2);
        return result;
    }
    public boolean canMouseWin(String[] grid,int catJump,int mouseJump){
        this.grid=grid;
        this.catJump=catJump;
        this.mouseJump=mouseJump;
        rows=grid.length;
        cols=grid[0].length();
        cells=rows*cols;
        int mouse=0,cat=0;
        for(int row=0;row<rows;row++)for(int col=0;col<cols;col++){
            char cell=grid[row].charAt(col);
            if(cell=='M')mouse=row*cols+col;
            else if(cell=='C')cat=row*cols+col;
            else if(cell=='F')food=row*cols+col;
        }
        memo=new byte[1000*cells*cells];
        return dfs(0,mouse,cat);
    }
}
