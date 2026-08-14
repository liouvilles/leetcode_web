class Solution {
    fun isPalindrome(value: Int): Boolean {
        if (value < 0 || (value % 10 == 0 && value != 0)) return false
        var x = value
        var reversed = 0
        while (x > reversed) {
            reversed = reversed * 10 + x % 10
            x /= 10
        }
        return x == reversed || x == reversed / 10
    }
}
