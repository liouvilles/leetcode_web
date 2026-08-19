class Solution {
    fun findSpecialInteger(arr:IntArray):Int{
        var start=0;
        while(start<arr.size){
            var end=start+1;
            while(end<arr.size&&arr[end]==arr[start])end++;
            if((end-start)*4>arr.size)return arr[start];
            start=end
        };
        return -1
    }
}
