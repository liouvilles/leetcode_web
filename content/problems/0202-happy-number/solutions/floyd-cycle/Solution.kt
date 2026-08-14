class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = n; var fast = next(n)
        while (fast != 1 && slow != fast) { slow = next(slow); fast = next(next(fast)) }
        return fast == 1
    }
    private fun next(input: Int): Int { var value = input; var sum = 0; while (value > 0) { val digit = value % 10; sum += digit * digit; value /= 10 }; return sum }
}
