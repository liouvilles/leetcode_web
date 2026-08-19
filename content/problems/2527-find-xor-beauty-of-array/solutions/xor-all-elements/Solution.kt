class Solution {
    fun xorBeauty(nums:IntArray):Int=nums.fold(0){
        answer,value->answer xor value
    }
}
