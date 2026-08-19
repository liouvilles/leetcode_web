class Solution {
    fun numberOfPairs(nums:IntArray):IntArray{
        val frequency=HashMap<Int,Int>();
        for(value in nums)frequency[value]=(frequency[value]?:0)+1;
        var pairs=0;
        var leftovers=0;
        for(count in frequency.values){
            pairs+=count/2;
            leftovers+=count%2
        };
        return intArrayOf(pairs,leftovers)
    }
}
