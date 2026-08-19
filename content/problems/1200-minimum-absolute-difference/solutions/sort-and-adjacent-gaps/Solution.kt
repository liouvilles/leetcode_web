class Solution {
    fun minimumAbsDifference(arr:IntArray):List<List<Int>>{
        arr.sort();
        var minimum=Int.MAX_VALUE;
        for(i in 1 until arr.size)minimum=minOf(minimum,arr[i]-arr[i-1]);
        val answer=mutableListOf<List<Int>>();
        for(i in 1 until arr.size)if(arr[i]-arr[i-1]==minimum)answer.add(listOf(arr[i-1],arr[i]));
        return answer
    }
}
