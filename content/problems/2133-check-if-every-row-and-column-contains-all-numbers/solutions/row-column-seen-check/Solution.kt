class Solution {
    fun checkValid(matrix:Array<IntArray>):Boolean{
        val n=matrix.size;
        for(i in 0 until n){
            val row=BooleanArray(n+1);
            val column=BooleanArray(n+1);
            for(j in 0 until n){
                val a=matrix[i][j];
                val b=matrix[j][i];
                if(a !in 1..n||row[a]||b !in 1..n||column[b])return false;
                row[a]=true;
                column[b]=true
            }
        };
        return true
    }
}
