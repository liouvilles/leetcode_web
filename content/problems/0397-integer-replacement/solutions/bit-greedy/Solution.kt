class Solution {
    fun integerReplacement(n:Int):Int{
        var value=n.toLong();
        var steps=0;
        while(value!=1L){
            value=if(value and 1L==0L)value shr 1 else if(value==3L||value and 2L==0L)value-1 else value+1;
            steps++
        };
        return steps
    }
}
