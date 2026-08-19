class Solution { fun evenOddBit(nInput:Int):IntArray{var n=nInput;val answer=IntArray(2);var position=0;while(n>0){if(n and 1==1)answer[position and 1]++;n=n shr 1;position++};return answer} }
