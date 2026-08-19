class Solution {
    fun largestMultipleOfThree(digits:IntArray):String{
        val count=IntArray(10);
        var sum=0;
        for(digit in digits){
            count[digit]++;
            sum+=digit
        };
        fun remove(remainder:Int,needed:Int):Boolean{
            var amount=needed;
            for(digit in 0..9)while(count[digit]>0&&digit%3==remainder&&amount>0){
                count[digit]--;
                amount--
            };
            return amount==0
        };
        val remainder=sum%3;
        if(remainder==1&&!remove(1,1)&&!remove(2,2))return "";
        if(remainder==2&&!remove(2,1)&&!remove(1,2))return "";
        val answer=StringBuilder();
        for(digit in 9 downTo 0)repeat(count[digit]){
            answer.append(digit)
        };
        return if(answer.isNotEmpty()&&answer[0]=='0')"0" else answer.toString()
    }
}
