class Solution {
    fun maxCount(m:Int,n:Int,ops:Array<IntArray>):Int{
        var rows=m;
        var columns=n;
        for(operation in ops){
            rows=minOf(rows,operation[0]);
            columns=minOf(columns,operation[1])
        };
        return rows*columns
    }
}
