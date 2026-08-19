class Solution {
    fun minSetSize(arr:IntArray):Int{
        val frequency=mutableMapOf<Int,Int>();
        for(value in arr)frequency[value]=(frequency[value]?:0)+1;
        var removed=0;
        var answer=0;
        for(count in frequency.values.sortedDescending()){
            removed+=count;
            answer++;
            if(removed*2>=arr.size)break
        };
        return answer
    }
}
