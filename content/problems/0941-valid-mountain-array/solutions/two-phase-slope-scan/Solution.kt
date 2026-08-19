class Solution {
    fun validMountainArray(arr:IntArray):Boolean{
        if(arr.size<3)return false;
        var i=0;
        while(i+1<arr.size&&arr[i]<arr[i+1])i++;
        if(i==0||i==arr.lastIndex)return false;
        while(i+1<arr.size&&arr[i]>arr[i+1])i++;
        return i==arr.lastIndex
    }
}
