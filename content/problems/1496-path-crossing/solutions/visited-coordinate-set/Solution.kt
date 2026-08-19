class Solution {
    fun isPathCrossing(path:String):Boolean{
        var x=0;
        var y=0;
        val seen=mutableSetOf("0,0");
        for(direction in path){
            when(direction){
                'N'->y++;
                'S'->y--;
                'E'->x++;
                else->x--
            };
            if(!seen.add("$x,$y"))return true
        };
        return false
    }
}
