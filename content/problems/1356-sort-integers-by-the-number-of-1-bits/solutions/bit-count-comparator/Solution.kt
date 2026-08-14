class Solution { fun sortByBits(arr:IntArray):IntArray=arr.sortedWith(compareBy<Int>{Integer.bitCount(it)}.thenBy{it}).toIntArray() }
