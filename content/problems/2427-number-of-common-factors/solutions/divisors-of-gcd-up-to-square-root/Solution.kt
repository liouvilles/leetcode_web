class Solution {
    fun commonFactors(aValue:Int,bValue:Int):Int{
        var a=aValue;
        var b=bValue;
        while(b!=0){
            val t=a%b;
            a=b;
            b=t
        };
        var answer=0;
        var divisor=1;
        while(divisor*divisor<=a){
            if(a%divisor==0)answer+=if(divisor*divisor==a)1 else 2;
            divisor++
        };
        return answer
    }
}
