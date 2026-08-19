class Solution {
    fun numMovesStones(a:Int,b:Int,c:Int):IntArray{
        val values=intArrayOf(a,b,c);
        values.sort();
        val maximum=values[2]-values[0]-2;
        val minimum=if(values[1]-values[0]==1&&values[2]-values[1]==1)0 else if(values[1]-values[0]<=2||values[2]-values[1]<=2)1 else 2;
        return intArrayOf(minimum,maximum)
    }
}
