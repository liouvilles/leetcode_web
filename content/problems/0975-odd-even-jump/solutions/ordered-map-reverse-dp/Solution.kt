class Solution {
    fun oddEvenJumps(arr:IntArray):Int{
        val n=arr.size;
        val odd=BooleanArray(n);
        val even=BooleanArray(n);
        odd[n-1]=true;
        even[n-1]=true;
        var answer=1;
        val map=java.util.TreeMap<Int,Int>();
        map[arr[n-1]]=n-1;
        for(i in n-2 downTo 0){
            val higher=map.ceilingEntry(arr[i]);
            val lower=map.floorEntry(arr[i]);
            if(higher!=null)odd[i]=even[higher.value];
            if(lower!=null)even[i]=odd[lower.value];
            if(odd[i])answer++;
            map[arr[i]]=i
        };
        return answer
    }
}
