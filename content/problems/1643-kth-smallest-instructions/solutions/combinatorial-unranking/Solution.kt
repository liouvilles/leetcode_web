class Solution {
    private fun combination(n:Int,chooseValue:Int):Long{
        val choose=minOf(chooseValue,n-chooseValue);
        var answer=1L;
        for(i in 1..choose)answer=answer*(n-i+1)/i;
        return answer
    };
    fun kthSmallestPath(destination:IntArray,kValue:Int):String{
        var vertical=destination[0];
        var horizontal=destination[1];
        var k=kValue.toLong();
        val answer=StringBuilder();
        while(horizontal>0&&vertical>0){
            val startWithH=combination(horizontal+vertical-1,vertical);
            if(k<=startWithH){
                answer.append('H');
                horizontal--
            }else{
                answer.append('V');
                vertical--;
                k-=startWithH
            }
        };
        repeat(horizontal){
            answer.append('H')
        };
        repeat(vertical){
            answer.append('V')
        };
        return answer.toString()
    }
}
