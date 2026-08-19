class Solution {
    fun mctFromLeafValues(arr:IntArray):Int{
        val stack=java.util.ArrayDeque<Int>();
        stack.push(Int.MAX_VALUE);
        var cost=0;
        for(value in arr){
            while(stack.peek()<=value){
                val middle=stack.pop();
                cost+=middle*minOf(stack.peek(),value)
            };
            stack.push(value)
        };
        while(stack.size>2)cost+=stack.pop()*stack.peek();
        return cost
    }
}
