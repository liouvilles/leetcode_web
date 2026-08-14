class Solution { fun decode(encoded:IntArray,first:Int):IntArray{val answer=IntArray(encoded.size+1);answer[0]=first;for(i in encoded.indices)answer[i+1]=answer[i] xor encoded[i];return answer} }
