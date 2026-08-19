class Solution {
    companion object{
        const val MOD=1_000_000_007L
    };
    private lateinit var sum:LongArray;
    private lateinit var square:LongArray;
    private lateinit var lazy:LongArray;
    private fun apply(node:Int,left:Int,right:Int,add:Long){
        val length=(right-left+1).toLong();
        square[node]=(square[node]+2L*add%MOD*sum[node]%MOD+add*add%MOD*length%MOD)%MOD;
        sum[node]=(sum[node]+add*length)%MOD;
        lazy[node]+=add
    }
    private fun push(node:Int,left:Int,right:Int){
        val add=lazy[node];
        if(add==0L||left==right)return;
        val middle=(left+right)/2;
        apply(node*2,left,middle,add);
        apply(node*2+1,middle+1,right,add);
        lazy[node]=0
    }
    private fun update(node:Int,left:Int,right:Int,queryLeft:Int,queryRight:Int){
        if(queryLeft<=left&&right<=queryRight){
            apply(node,left,right,1);
            return
        };
        push(node,left,right);
        val middle=(left+right)/2;
        if(queryLeft<=middle)update(node*2,left,middle,queryLeft,queryRight);
        if(queryRight>middle)update(node*2+1,middle+1,right,queryLeft,queryRight);
        sum[node]=(sum[node*2]+sum[node*2+1])%MOD;
        square[node]=(square[node*2]+square[node*2+1])%MOD
    }
    fun sumCounts(nums:IntArray):Int{
        val n=nums.size;
        sum=LongArray(4*n);
        square=LongArray(4*n);
        lazy=LongArray(4*n);
        val last=HashMap<Int,Int>();
        var answer=0L;
        for(index in nums.indices){
            val previous=last[nums[index]]?:-1;
            update(1,0,n-1,previous+1,index);
            answer=(answer+square[1])%MOD;
            last[nums[index]]=index
        };
        return answer.toInt()
    }
}
