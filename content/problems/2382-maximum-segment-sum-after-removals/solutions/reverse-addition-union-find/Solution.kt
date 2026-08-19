class Solution {
    fun maximumSegmentSum(nums:IntArray,removeQueries:IntArray):LongArray{
        val n=nums.size;
        val parent=IntArray(n);
        val sum=LongArray(n);
        val active=BooleanArray(n);
        fun find(value:Int):Int{
            var x=value;
            while(parent[x]!=x){
                parent[x]=parent[parent[x]];
                x=parent[x]
            };
            return x
        };
        fun union(x:Int,y:Int){
            val a=find(x);
            val b=find(y);
            if(a!=b){
                parent[b]=a;
                sum[a]+=sum[b]
            }
        };
        val answer=LongArray(n);
        var maximum=0L;
        for(i in n-1 downTo 0){
            answer[i]=maximum;
            val index=removeQueries[i];
            parent[index]=index;
            sum[index]=nums[index].toLong();
            active[index]=true;
            if(index>0&&active[index-1])union(index,index-1);
            if(index+1<n&&active[index+1])union(index,index+1);
            maximum=maxOf(maximum,sum[find(index)])
        };
        return answer
    }
}
