class Solution {
    fun largestPalindromic(num:String):String{
        val count=IntArray(10);
        for(ch in num)count[ch-'0']++;
        val left=StringBuilder();
        for(digit in 9 downTo 0){
            val pairs=count[digit]/2;
            if(digit==0&&left.isEmpty())continue;
            repeat(pairs){
                left.append(digit)
            };
            count[digit]-=pairs*2
        };
        var center:Char?=null;
        for(digit in 9 downTo 0)if(count[digit]>0){
            center=('0'.code+digit).toChar();
            break
        };
        val answer=StringBuilder(left);
        if(center!=null)answer.append(center);
        answer.append(left.reversed());
        return if(answer.isEmpty())"0" else answer.toString()
    }
}
