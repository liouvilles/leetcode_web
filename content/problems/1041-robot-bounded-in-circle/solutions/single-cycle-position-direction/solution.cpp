class Solution {
    public: bool isRobotBounded(string instructions){
        int directions[4][2]={
            {
                0,1
            },{
                1,0
            },{
                0,-1
            },{
                -1,0
            }
        },x=0,y=0,direction=0;
        for(char command:instructions)if(command=='G'){
            x+=directions[direction][0];
            y+=directions[direction][1];
        }else if(command=='L')direction=(direction+3)%4;
        else direction=(direction+1)%4;
        return x==0&&y==0||direction!=0;
    }
};
