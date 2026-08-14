class Solution { fun getXORSum(arr1:IntArray,arr2:IntArray):Int=arr1.fold(0){a,v->a xor v} and arr2.fold(0){a,v->a xor v} }
