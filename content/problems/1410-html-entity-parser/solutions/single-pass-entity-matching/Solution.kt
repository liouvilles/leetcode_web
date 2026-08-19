class Solution {
    fun entityParser(text:String):String{
        val entities=listOf("&quot;" to "\"","&apos;" to "'","&amp;" to "&","&gt;" to ">","&lt;" to "<","&frasl;" to "/");
        val answer=StringBuilder();
        var i=0;
        while(i<text.length){
            val match=if(text[i]=='&')entities.firstOrNull{
                text.startsWith(it.first,i)
            }else null;
            if(match==null)answer.append(text[i++])else{
                answer.append(match.second);
                i+=match.first.length
            }
        };
        return answer.toString()
    }
}
