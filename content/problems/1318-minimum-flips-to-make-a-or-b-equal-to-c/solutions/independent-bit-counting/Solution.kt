class Solution {
    fun minFlips(aValue:Int,bValue:Int,cValue:Int):Int{
        var a=aValue;
        var b=bValue;
        var c=cValue;
        var answer=0;
        while(a!=0||b!=0||c!=0){
            val bitA=a and 1;
            val bitB=b and 1;
            val bitC=c and 1;
            if(bitC==1){
                if((bitA or bitB)==0)answer++
            }else answer+=bitA+bitB;
            a=a ushr 1;
            b=b ushr 1;
            c=c ushr 1
        };
        return answer
    }
}
