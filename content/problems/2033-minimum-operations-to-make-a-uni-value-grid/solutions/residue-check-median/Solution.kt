class Solution {
    fun minOperations(grid:Array<IntArray>,x:Int):Int{
        val values=grid.flatMap{
            it.asList()
        }.toIntArray();
        val remainder=values[0]%x;
        if(values.any{
            it%x!=remainder
        })return -1;
        values.sort();
        val target=values[values.size/2];
        return values.sumOf{
            kotlin.math.abs(it-target)/x
        }
    }
}
