class Solution {
    fun isRobotBounded(instructions:String):Boolean{
        val directions=arrayOf(intArrayOf(0,1),intArrayOf(1,0),intArrayOf(0,-1),intArrayOf(-1,0));
        var x=0;
        var y=0;
        var direction=0;
        for(command in instructions)if(command=='G'){
            x+=directions[direction][0];
            y+=directions[direction][1]
        }else if(command=='L')direction=(direction+3)%4 else direction=(direction+1)%4;
        return x==0&&y==0||direction!=0
    }
}
