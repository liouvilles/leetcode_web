class Solution {
    fun prevPermOpt1(arr:IntArray):IntArray{
        var i=arr.size-2;
        while(i>=0&&arr[i]<=arr[i+1])i--;
        if(i<0)return arr;
        var j=arr.lastIndex;
        while(arr[j]>=arr[i])j--;
        while(j>i+1&&arr[j-1]==arr[j])j--;
        val temporary=arr[i];
        arr[i]=arr[j];
        arr[j]=temporary;
        return arr
    }
}
