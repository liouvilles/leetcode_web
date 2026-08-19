class Solution {
    fun wordSubsets(words1:Array<String>,words2:Array<String>):List<String>{
        val requirement=IntArray(26);
        for(word in words2){
            val count=count(word);
            for(i in 0 until 26)requirement[i]=maxOf(requirement[i],count[i])
        };
        return words1.filter{
            word->val count=count(word);
            (0 until 26).all{
                count[it]>=requirement[it]
            }
        }
    };
    private fun count(word:String):IntArray{
        val result=IntArray(26);
        for(c in word)result[c-'a']++;
        return result
    }
}
