class Solution { fun minimumSum(n:Int,k:Int):Int{val first=minOf(n,k/2).toLong();val remaining=n-first;return (first*(first+1)/2+remaining*(2L*k+remaining-1)/2).toInt()} }
