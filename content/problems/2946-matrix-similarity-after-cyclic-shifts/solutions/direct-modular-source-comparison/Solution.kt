class Solution {
    fun areSimilar(mat:Array<IntArray>,k:Int):Boolean{
        val columns=mat[0].size;
        val shift=k%columns;
        for(row in mat.indices)for(column in 0 until columns){
            val source=if(row%2==0)(column+shift)%columns else (column-shift+columns)%columns;
            if(mat[row][source]!=mat[row][column])return false
        };
        return true
    }
}
