class Solution { fun maximumElementAfterDecrementingAndRearranging(arr:IntArray):Int{arr.sort();var current=0;for(value in arr)current=minOf(value,current+1);return current} }
