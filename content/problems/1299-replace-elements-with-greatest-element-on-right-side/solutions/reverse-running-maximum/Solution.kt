class Solution {
    fun replaceElements(arr:IntArray):IntArray{
        var maximum=-1;
        for(i in arr.lastIndex downTo 0){
            val original=arr[i];
            arr[i]=maximum;
            maximum=maxOf(maximum,original)
        };
        return arr
    }
}
