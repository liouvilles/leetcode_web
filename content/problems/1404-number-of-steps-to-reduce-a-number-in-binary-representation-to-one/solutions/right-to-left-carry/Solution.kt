class Solution {
    fun numSteps(binary:String):Int{
        var steps=0;
        var carry=0;
        for(i in binary.lastIndex downTo 1){
            val bit=binary[i]-'0'+carry;
            if(bit==1){
                steps+=2;
                carry=1
            }else steps++
        };
        return steps+carry
    }
}
