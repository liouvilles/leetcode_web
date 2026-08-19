class Solution {
    fun leastBricks(wall:List<List<Int>>):Int{
        val counts=hashMapOf<Long,Int>();
        var maximum=0;
        for(row in wall){
            var position=0L;
            for(i in 0 until row.lastIndex){
                position+=row[i];
                val count=(counts[position]?:0)+1;
                counts[position]=count;
                maximum=maxOf(maximum,count)
            }
        };
        return wall.size-maximum
    }
}
