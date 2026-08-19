class Solution {
    fun numberOfSets(n:Int,k:Int):Int{
        val mod=1_000_000_007L;
        val limit=n+k-1;
        val choose=2*k;
        val combination=Array(limit+1){
            LongArray(choose+1)
        };
        for(row in 0..limit){
            combination[row][0]=1;
            for(col in 1..minOf(row,choose))combination[row][col]=(combination[row-1][col-1]+combination[row-1][col])%mod
        };
        return combination[limit][choose].toInt()
    }
}
