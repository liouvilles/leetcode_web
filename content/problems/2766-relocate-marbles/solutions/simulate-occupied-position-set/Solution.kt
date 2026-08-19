class Solution {
    fun relocateMarbles(nums:IntArray,moveFrom:IntArray,moveTo:IntArray):List<Int>{
        val positions=nums.toMutableSet();
        for(i in moveFrom.indices){
            positions.remove(moveFrom[i]);
            positions.add(moveTo[i])
        };
        return positions.sorted()
    }
}
