class Solution { fun hasAlternatingBits(n:Int):Boolean{val value=n xor (n shr 1);return value and (value+1)==0} }
