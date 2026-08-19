class Solution {
    fun maximumSumQueries(nums1:IntArray,nums2:IntArray,queries:Array<IntArray>):IntArray{
        val n=nums1.size;
        val points=Array(n){
            it
        };
        val order=Array(queries.size){
            it
        };
        points.sortWith(Comparator{
            a,b->nums1[b].compareTo(nums1[a])
        });
        order.sortWith(Comparator{
            a,b->queries[b][0].compareTo(queries[a][0])
        });
        val values=nums2.clone();
        values.sort();
        fun lowerBound(target:Int):Int{
            var left=0;
            var right=n;
            while(left<right){
                val middle=(left+right) ushr 1;
                if(values[middle]<target)left=middle+1 else right=middle
            };
            return left
        };
        val bit=IntArray(n+1);
        fun update(input:Int,value:Int){
            var index=input;
            while(index<bit.size){
                bit[index]=maxOf(bit[index],value);
                index+=index and -index
            }
        };
        fun query(input:Int):Int{
            var index=input;
            var result=0;
            while(index>0){
                result=maxOf(result,bit[index]);
                index-=index and -index
            };
            return result
        };
        val answer=IntArray(queries.size);
        var added=0;
        for(queryIndex in order){
            val x=queries[queryIndex][0];
            val y=queries[queryIndex][1];
            while(added<n&&nums1[points[added]]>=x){
                val point=points[added++];
                update(n-lowerBound(nums2[point]),nums1[point]+nums2[point])
            };
            val best=query(n-lowerBound(y));
            answer[queryIndex]=if(best==0)-1 else best
        };
        return answer
    }
}
