class Solution {
    public boolean isRobotBounded(String instructions){
        int[][] directions={
            {
                0,1
            },{
                1,0
            },{
                0,-1
            },{
                -1,0
            }
        };
        int x=0,y=0,direction=0;
        for(char command:instructions.toCharArray())if(command=='G'){
            x+=directions[direction][0];
            y+=directions[direction][1];
        }else if(command=='L')direction=(direction+3)%4;
        else direction=(direction+1)%4;
        return x==0&&y==0||direction!=0;
    }
}
