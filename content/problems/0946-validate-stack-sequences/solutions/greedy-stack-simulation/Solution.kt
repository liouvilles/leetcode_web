class Solution {
    fun validateStackSequences(pushed:IntArray,popped:IntArray):Boolean{
        val stack=java.util.ArrayDeque<Int>();
        var index=0;
        for(value in pushed){
            stack.push(value);
            while(stack.isNotEmpty()&&index<popped.size&&stack.peek()==popped[index]){
                stack.pop();
                index++
            }
        };
        return index==popped.size
    }
}
