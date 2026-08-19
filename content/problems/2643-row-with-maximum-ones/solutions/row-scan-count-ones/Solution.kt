class Solution {
    fun rowAndMaximumOnes(mat:Array<IntArray>):IntArray{
        var bestRow=0;
        var bestCount=0;
        for(row in mat.indices){
            val count=mat[row].sum();
            if(count>bestCount){
                bestCount=count;
                bestRow=row
            }
        };
        return intArrayOf(bestRow,bestCount)
    }
}
