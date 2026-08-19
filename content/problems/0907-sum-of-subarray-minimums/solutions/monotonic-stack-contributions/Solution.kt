class Solution {
    fun sumSubarrayMins(arr:IntArray):Int{
        val mod=1000000007L;
        var answer=0L;
        val stack=java.util.ArrayDeque<Int>();
        for(i in 0..arr.size){
            while(stack.isNotEmpty()&&(i==arr.size||arr[stack.peek()]>=arr[i])){
                val middle=stack.pop();
                val left=if(stack.isEmpty())-1 else stack.peek();
                answer=(answer+arr[middle].toLong()*(middle-left)*(i-middle))%mod
            };
            if(i<arr.size)stack.push(i)
        };
        return answer.toInt()
    }
}
