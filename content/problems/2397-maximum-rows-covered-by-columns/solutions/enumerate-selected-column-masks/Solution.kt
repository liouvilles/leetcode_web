class Solution {
    fun maximumRows(matrix:Array<IntArray>,numSelect:Int):Int{
        val columns=matrix[0].size;
        val masks=IntArray(matrix.size);
        for(r in matrix.indices)for(c in 0 until columns)if(matrix[r][c]==1)masks[r]=masks[r] or (1 shl c);
        var answer=0;
        for(selected in 0 until (1 shl columns))if(Integer.bitCount(selected)==numSelect){
            var covered=0;
            for(mask in masks)if(mask and selected==mask)covered++;
            answer=maxOf(answer,covered)
        };
        return answer
    }
}
