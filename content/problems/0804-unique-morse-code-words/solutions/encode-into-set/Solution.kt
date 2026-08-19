class Solution {
    fun uniqueMorseRepresentations(words:Array<String>):Int{
        val code=arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..");
        return words.map{
            word->buildString{
                for(c in word)append(code[c-'a'])
            }
        }.toSet().size
    }
}
