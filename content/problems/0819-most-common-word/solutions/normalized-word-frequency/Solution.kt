class Solution {
    fun mostCommonWord(paragraph:String,banned:Array<String>):String{
        val blocked=banned.toSet();
        val frequency=mutableMapOf<String,Int>();
        var answer="";
        var best=0;
        for(word in paragraph.lowercase().split(Regex("[^a-z]+"))){
            if(word.isEmpty()||word in blocked)continue;
            val count=(frequency[word]?:0)+1;
            frequency[word]=count;
            if(count>best){
                best=count;
                answer=word
            }
        };
        return answer
    }
}
