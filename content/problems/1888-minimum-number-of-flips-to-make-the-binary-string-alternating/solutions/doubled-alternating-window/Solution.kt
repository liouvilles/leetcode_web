class Solution {
    fun minFlips(s:String):Int{
        val n=s.length;
        var zero=0;
        var one=0;
        var answer=n;
        for(i in 0 until 2*n){
            val value=s[i%n];
            val expectedZero=if(i%2==0)'0' else '1';
            if(value!=expectedZero)zero++ else one++;
            if(i>=n){
                val old=i-n;
                val oldValue=s[old%n];
                val oldExpected=if(old%2==0)'0' else '1';
                if(oldValue!=oldExpected)zero-- else one--
            };
            if(i>=n-1)answer=minOf(answer,zero,one)
        };
        return answer
    }
}
