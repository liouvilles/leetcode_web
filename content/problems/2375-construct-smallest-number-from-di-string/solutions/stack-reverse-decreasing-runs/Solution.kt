class Solution {
    fun smallestNumber(pattern:String):String{
        val answer=StringBuilder();
        val stack=java.util.ArrayDeque<Int>();
        for(i in 0..pattern.length){
            stack.push(i+1);
            if(i==pattern.length||pattern[i]=='I')while(stack.isNotEmpty())answer.append(stack.pop())
        };
        return answer.toString()
    }
}
