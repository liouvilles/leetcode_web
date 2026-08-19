class Solution {
    fun removeKdigits(num:String,inputK:Int):String{
        var k=inputK;
        val stack=StringBuilder();
        for(c in num){
            while(k>0&&stack.isNotEmpty()&&stack.last()>c){
                stack.deleteCharAt(stack.lastIndex);
                k--
            };
            stack.append(c)
        };
        while(k-->0)stack.deleteCharAt(stack.lastIndex);
        var start=0;
        while(start<stack.length&&stack[start]=='0')start++;
        return if(start==stack.length)"0" else stack.substring(start)
    }
}
