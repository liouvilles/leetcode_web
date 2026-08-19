class Solution {
    fun numberOfPairs(nums1:IntArray,nums2:IntArray,diff:Int):Long{
        val values=IntArray(nums1.size){
            nums1[it]-nums2[it]
        };
        val coordinates=values.distinct().sorted();
        fun lower(target:Int):Int{
            var left=0;
            var right=coordinates.size;
            while(left<right){
                val middle=(left+right)/2;
                if(coordinates[middle]<target)left=middle+1 else right=middle
            };
            return left
        };
        fun upper(target:Int):Int{
            var left=0;
            var right=coordinates.size;
            while(left<right){
                val middle=(left+right)/2;
                if(coordinates[middle]<=target)left=middle+1 else right=middle
            };
            return left
        };
        val tree=IntArray(coordinates.size+1);
        var answer=0L;
        for(value in values){
            var index=upper(value+diff);
            while(index>0){
                answer+=tree[index];
                index-=index and -index
            };
            index=lower(value)+1;
            while(index<tree.size){
                tree[index]++;
                index+=index and -index
            }
        };
        return answer
    }
}
