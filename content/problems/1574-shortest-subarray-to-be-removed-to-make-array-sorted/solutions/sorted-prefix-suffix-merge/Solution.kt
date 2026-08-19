class Solution {
    fun findLengthOfShortestSubarray(arr:IntArray):Int{
        val n=arr.size;
        var left=0;
        while(left+1<n&&arr[left]<=arr[left+1])left++;
        if(left==n-1)return 0;
        var right=n-1;
        while(right>0&&arr[right-1]<=arr[right])right--;
        var answer=minOf(n-left-1,right);
        var i=0;
        var j=right;
        while(i<=left&&j<n)if(arr[i]<=arr[j]){
            answer=minOf(answer,j-i-1);
            i++
        }else j++;
        return answer
    }
}
