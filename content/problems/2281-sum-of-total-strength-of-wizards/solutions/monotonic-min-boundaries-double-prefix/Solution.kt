class Solution {
    fun totalStrength(strength:IntArray):Int{
        val mod=1_000_000_007L;
        val n=strength.size;
        val left=IntArray(n);
        val right=IntArray(n);
        val stack=java.util.ArrayDeque<Int>();
        for(i in 0 until n){
            while(stack.isNotEmpty()&&strength[stack.peek()]>=strength[i])stack.pop();
            left[i]=if(stack.isEmpty())-1 else stack.peek();
            stack.push(i)
        };
        stack.clear();
        for(i in n-1 downTo 0){
            while(stack.isNotEmpty()&&strength[stack.peek()]>strength[i])stack.pop();
            right[i]=if(stack.isEmpty())n else stack.peek();
            stack.push(i)
        };
        val pre=LongArray(n+1);
        val pp=LongArray(n+2);
        for(i in 0 until n)pre[i+1]=(pre[i]+strength[i])%mod;
        for(i in 0..n)pp[i+1]=(pp[i]+pre[i])%mod;
        var answer=0L;
        for(i in 0 until n){
            val positive=(i-left[i]).toLong()*((pp[right[i]+1]-pp[i+1]+mod)%mod)%mod;
            val negative=(right[i]-i).toLong()*((pp[i+1]-pp[left[i]+1]+mod)%mod)%mod;
            val ranges=(positive-negative+mod)%mod;
            answer=(answer+strength[i]*ranges)%mod
        };
        return answer.toInt()
    }
}
