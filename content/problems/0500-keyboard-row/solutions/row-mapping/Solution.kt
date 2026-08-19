class Solution {
    fun findWords(words:Array<String>):Array<String>{
        val rows=listOf("qwertyuiop","asdfghjkl","zxcvbnm");
        return words.filter{
            word->val lower=word.lowercase();
            rows.any{
                row->lower.all{
                    it in row
                }
            }
        }.toTypedArray()
    }
}
