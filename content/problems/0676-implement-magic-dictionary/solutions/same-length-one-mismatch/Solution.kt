class MagicDictionary {
    private val words=hashMapOf<Int,MutableList<String>>();
    fun buildDict(dictionary:Array<String>){
        for(word in dictionary)words.getOrPut(word.length){
            mutableListOf()
        }.add(word)
    };
    fun search(searchWord:String):Boolean{
        for(word in words[searchWord.length]?:emptyList()){
            var differences=0;
            for(i in word.indices){
                if(word[i]!=searchWord[i])differences++;
                if(differences>1)break
            };
            if(differences==1)return true
        };
        return false
    }
}
