class Solution {
    fun oddString(words:Array<String>):String{
        val key={
            word:String->buildString{
                for(i in 1 until word.length)append(word[i]-word[i-1]).append(',')
            }
        };
        val frequency=HashMap<String,Int>();
        for(word in words){
            val k=key(word);
            frequency[k]=(frequency[k]?:0)+1
        };
        return words.first{
            frequency[key(it)]==1
        }
    }
}
