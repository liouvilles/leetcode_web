class Solution {
    fun makeGood(text:String):String{
        val stack=StringBuilder();
        for(value in text)if(stack.isNotEmpty()&&kotlin.math.abs(stack.last()-value)==32)stack.deleteCharAt(stack.lastIndex)else stack.append(value);
        return stack.toString()
    }
}
