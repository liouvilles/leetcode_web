class Solution {
    fun maximumGood(statements:Array<IntArray>):Int{
        val n=statements.size;
        var answer=0;
        for(mask in 0 until (1 shl n)){
            var valid=true;
            loop@for(i in 0 until n)if(mask and (1 shl i)!=0)for(j in 0 until n)if(statements[i][j]!=2&&statements[i][j]!=(mask shr j and 1)){
                valid=false;
                break@loop
            };
            if(valid)answer=maxOf(answer,Integer.bitCount(mask))
        };
        return answer
    }
}
