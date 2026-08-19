class Solution {
    fun canMakeArithmeticProgression(arr:IntArray):Boolean{
        arr.sort();
        val difference=arr[1]-arr[0];
        return (2 until arr.size).all{
            arr[it]-arr[it-1]==difference
        }
    }
}
