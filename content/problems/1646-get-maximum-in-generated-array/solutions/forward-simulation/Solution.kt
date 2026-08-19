class Solution {
    fun getMaximumGenerated(n:Int):Int{
        if(n==0)return 0;
        val nums=IntArray(n+1);
        nums[1]=1;
        var answer=1;
        for(i in 2..n){
            nums[i]=if(i%2==0)nums[i/2] else nums[i/2]+nums[i/2+1];
            answer=maxOf(answer,nums[i])
        };
        return answer
    }
}
