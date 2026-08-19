class Solution {
    private fun swaps(s:String,start:Char):Int{
        var mismatch=0;
        for(i in s.indices){
            val expected=if(i%2==0)start else if(start=='0')'1' else '0';
            if(s[i]!=expected)mismatch++
        };
        return mismatch/2
    };
    fun minSwaps(s:String):Int{
        val zeros=s.count{
            it=='0'
        };
        val ones=s.length-zeros;
        if(kotlin.math.abs(zeros-ones)>1)return -1;
        if(zeros==ones)return minOf(swaps(s,'0'),swaps(s,'1'));
        return swaps(s,if(zeros>ones)'0' else '1')
    }
}
