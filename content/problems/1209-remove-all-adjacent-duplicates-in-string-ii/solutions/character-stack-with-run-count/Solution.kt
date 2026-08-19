class Solution {
    fun removeDuplicates(s:String,k:Int):String{
        val stack=StringBuilder();
        val counts=IntArray(s.length);
        for(ch in s){
            val index=stack.length;
            counts[index]=if(index>0&&stack[index-1]==ch)counts[index-1]+1 else 1;
            stack.append(ch);
            if(counts[index]==k)stack.delete(stack.length-k,stack.length)
        };
        return stack.toString()
    }
}
