class WordFilter(words:Array<String>){
    private val indices=hashMapOf<String,Int>();
    init{
        for((index,word) in words.withIndex())for(prefix in 0..word.length)for(suffix in 0..word.length)indices[word.substring(0,prefix)+"#"+word.substring(suffix)]=index
    };
    fun f(pref:String,suff:String):Int=indices[pref+"#"+suff]?:-1
}
