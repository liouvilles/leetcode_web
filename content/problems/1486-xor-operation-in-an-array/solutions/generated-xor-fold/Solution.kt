class Solution {
    fun xorOperation(n:Int,start:Int):Int{
        var answer=0;
        for(i in 0 until n)answer=answer xor (start+2*i);
        return answer
    }
}
