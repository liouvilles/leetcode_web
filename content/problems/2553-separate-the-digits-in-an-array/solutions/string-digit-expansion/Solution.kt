class Solution {
    fun separateDigits(nums:IntArray):IntArray{
        return nums.flatMap{
            it.toString().map{
                character->character-'0'
            }
        }.toIntArray()
    }
}
