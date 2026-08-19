class Solution {
    fun minOperations(text:String):Int{
        val mismatch=text.indices.count{
            text[it]!=('0'.code+it%2).toChar()
        };
        return minOf(mismatch,text.length-mismatch)
    }
}
