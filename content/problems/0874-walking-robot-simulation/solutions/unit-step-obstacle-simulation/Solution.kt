class Solution {
    fun robotSim(commands:IntArray,obstacles:Array<IntArray>):Int{
        val blocked=obstacles.map{
            it[0] to it[1]
        }.toSet();
        val directions=arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(0,-1),intArrayOf(-1,0));
        var direction=0;
        var x=0;
        var y=0;
        var answer=0;
        for(command in commands){
            if(command==-1)direction=(direction+1)%4 else if(command==-2)direction=(direction+3)%4 else repeat(command){
                val nextX=x+directions[direction][0];
                val nextY=y+directions[direction][1];
                if(nextX to nextY in blocked)return@repeat;
                x=nextX;
                y=nextY;
                answer=maxOf(answer,x*x+y*y)
            }
        };
        return answer
    }
}
