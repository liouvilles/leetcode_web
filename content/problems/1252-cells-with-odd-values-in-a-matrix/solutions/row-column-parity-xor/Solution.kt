class Solution {
    fun oddCells(m:Int,n:Int,indices:Array<IntArray>):Int{
        val rows=BooleanArray(m);
        val columns=BooleanArray(n);
        for(index in indices){
            rows[index[0]]=!rows[index[0]];
            columns[index[1]]=!columns[index[1]]
        };
        var answer=0;
        for(row in rows)for(column in columns)if(row xor column)answer++;
        return answer
    }
}
