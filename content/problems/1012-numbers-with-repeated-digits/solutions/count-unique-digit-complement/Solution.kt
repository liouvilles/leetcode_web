class Solution {
    fun numDupDigitsAtMostN(n:Int):Int{
        val digits=n.toString();
        fun permutation(choices:Int,count:Int):Int{
            var result=1;
            for(i in 0 until count)result*=choices-i;
            return result
        };
        var unique=0;
        for(length in 1 until digits.length)unique+=9*permutation(9,length-1);
        val used=BooleanArray(10);
        for(i in digits.indices){
            val current=digits[i]-'0';
            val start=if(i==0)1 else 0;
            for(digit in start until current)if(!used[digit])unique+=permutation(9-i,digits.length-i-1);
            if(used[current])return n-unique;
            used[current]=true
        };
        return n-unique-1
    }
}
