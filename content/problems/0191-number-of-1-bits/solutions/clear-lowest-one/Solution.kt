class Solution {
    fun hammingWeight(input: Int): Int {
        var value = input; var answer = 0
        while (value != 0) { value = value and (value - 1); answer++ }
        return answer
    }
}
