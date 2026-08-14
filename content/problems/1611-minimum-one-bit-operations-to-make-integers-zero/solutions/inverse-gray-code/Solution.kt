class Solution { fun minimumOneBitOperations(nValue:Int):Int{var n=nValue;var answer=0;while(n>0){answer=answer xor n;n=n shr 1};return answer} }
