class Solution {
    fun minimizeXor(num1:Int,num2:Int):Int{
        var need=Integer.bitCount(num2);
        var answer=0;
        for(bit in 30 downTo 0)if(need>0&&num1 and (1 shl bit)!=0){
            answer=answer or (1 shl bit);
            need--
        };
        for(bit in 0..30)if(need>0&&answer and (1 shl bit)==0){
            answer=answer or (1 shl bit);
            need--
        };
        return answer
    }
}
