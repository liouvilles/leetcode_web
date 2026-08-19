class Solution {
    public int robotSim(int[] commands,int[][] obstacles){
        Set<String> blocked=new HashSet<>();
        for(int[] obstacle:obstacles)blocked.add(obstacle[0]+","+obstacle[1]);
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
        int direction=0,x=0,y=0,answer=0;
        for(int command:commands){
            if(command==-1)direction=(direction+1)%4;
            else if(command==-2)direction=(direction+3)%4;
            else for(int step=0;step<command;step++){
                int nextX=x+directions[direction][0],nextY=y+directions[direction][1];
                if(blocked.contains(nextX+","+nextY))break;
                x=nextX;
                y=nextY;
                answer=Math.max(answer,x*x+y*y);
            }
        }
        return answer;
    }
}
