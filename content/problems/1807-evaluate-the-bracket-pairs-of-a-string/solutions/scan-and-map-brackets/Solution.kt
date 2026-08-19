class Solution {
    fun evaluate(text:String,knowledge:List<List<String>>):String{
        val map=knowledge.associate{
            it[0] to it[1]
        };
        val answer=StringBuilder();
        var position=0;
        while(position<text.length)if(text[position]!='(')answer.append(text[position++]) else{
            val end=text.indexOf(')',position);
            answer.append(map[text.substring(position+1,end)]?:"?");
            position=end+1
        };
        return answer.toString()
    }
}
