class Solution {
    fun intToRoman(input: Int): String {
        val values = intArrayOf(1000,900,500,400,100,90,50,40,10,9,5,4,1); val symbols = arrayOf("M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I")
        var num = input; val answer = StringBuilder()
        for (index in values.indices) while (num >= values[index]) { num -= values[index]; answer.append(symbols[index]) }
        return answer.toString()
    }
}
