class Solution {
    fun findRightInterval(intervals:Array<IntArray>):IntArray{
        val starts=Array(intervals.size){
            intArrayOf(intervals[it][0],it)
        };
        starts.sortWith(Comparator.comparingInt{
            it[0]
        });
        return IntArray(intervals.size){
            i->var left=0;
            var right=starts.size;
            while(left<right){
                val middle=(left+right)/2;
                if(starts[middle][0]<intervals[i][1])left=middle+1 else right=middle
            };
            if(left==starts.size)-1 else starts[left][1]
        }
    }
}
