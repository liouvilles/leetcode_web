class Solution {
    private class Window(private val need:Int){
        private val small=java.util.TreeMap<Int,Int>();
        private val large=java.util.TreeMap<Int,Int>();
        private var smallSize=0;
        var sum=0L
        private set
        private fun insert(map:java.util.TreeMap<Int,Int>,value:Int){
            map[value]=(map[value]?:0)+1
        };
        private fun erase(map:java.util.TreeMap<Int,Int>,value:Int){
            val count=map[value]!!;
            if(count==1)map.remove(value)else map[value]=count-1
        }
        fun add(value:Int){
            insert(small,value);
            smallSize++;
            sum+=value;
            if(smallSize>need){
                val moved=small.lastKey();
                erase(small,moved);
                smallSize--;
                sum-=moved;
                insert(large,moved)
            }
        }
        fun remove(value:Int){
            if(small.containsKey(value)){
                erase(small,value);
                smallSize--;
                sum-=value
            }else erase(large,value);
            if(smallSize<need&&large.isNotEmpty()){
                val moved=large.firstKey();
                erase(large,moved);
                insert(small,moved);
                smallSize++;
                sum+=moved
            }
        }
    }
    fun minimumCost(nums:IntArray,k:Int,dist:Int):Long{
        val window=Window(k-1);
        for(index in 1..dist+1)window.add(nums[index]);
        var answer=nums[0]+window.sum;
        for(right in dist+2 until nums.size){
            window.remove(nums[right-dist-1]);
            window.add(nums[right]);
            answer=minOf(answer,nums[0]+window.sum)
        };
        return answer
    }
}
