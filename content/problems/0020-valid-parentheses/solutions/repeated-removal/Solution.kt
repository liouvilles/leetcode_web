class Solution {
    fun isValid(input: String): Boolean {
        var s = input
        do {
            val previousLength = s.length
            s = s.replace("()", "").replace("[]", "").replace("{}", "")
        } while (s.length != previousLength)
        return s.isEmpty()
    }
}
