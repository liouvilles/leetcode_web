class Solution {
    fun findTheDistanceValue(arr1:IntArray,arr2:IntArray,d:Int):Int{
        arr2.sort();
        var answer=0;
        for(value in arr1){
            val found=arr2.binarySearch(value);
            val index=if(found>=0)found else -found-1;
            val close=index<arr2.size&&kotlin.math.abs(arr2[index]-value)<=d||index>0&&kotlin.math.abs(arr2[index-1]-value)<=d;
            if(!close)answer++
        };
        return answer
    }
}
