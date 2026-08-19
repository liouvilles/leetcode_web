class Solution {
    fun findSolution(customfunction:CustomFunction,z:Int):List<List<Int>>{
        val answer=mutableListOf<List<Int>>();
        var x=1;
        var y=1000;
        while(x<=1000&&y>=1){
            val value=customfunction.f(x,y);
            if(value==z){
                answer.add(listOf(x,y));
                x++;
                y--
            }else if(value<z)x++ else y--
        };
        return answer
    }
}
