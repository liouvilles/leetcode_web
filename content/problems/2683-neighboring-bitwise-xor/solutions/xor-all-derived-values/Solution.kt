class Solution { fun doesValidArrayExist(derived:IntArray)=derived.fold(0){xor,value->xor xor value}==0 }
