class Solution {
    private fun palindrome(halfValue:Long,odd:Boolean):Long{
        var result=halfValue;
        var value=if(odd)halfValue/10 else halfValue;
        while(value>0){
            result=result*10+value%10;
            value/=10
        };
        return result
    };
    private fun basePalindrome(valueValue:Long,k:Int):Boolean{
        var value=valueValue;
        val digits=mutableListOf<Int>();
        while(value>0){
            digits.add((value%k).toInt());
            value/=k
        };
        return digits==digits.reversed()
    };
    fun kMirror(k:Int,nValue:Int):Long{
        var n=nValue;
        var answer=0L;
        var length=1;
        while(true){
            val halfLength=(length+1)/2;
            var start=1L;
            repeat(halfLength-1){
                start*=10
            };
            for(half in start until start*10){
                val value=palindrome(half,length%2==1);
                if(basePalindrome(value,k)){
                    answer+=value;
                    if(--n==0)return answer
                }
            };
            length++
        }
    }
}
