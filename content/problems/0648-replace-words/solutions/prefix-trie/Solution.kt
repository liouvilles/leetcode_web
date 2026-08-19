class Solution {
    private class Node{
        val next=arrayOfNulls<Node>(26);
        var end=false
    };
    private val root=Node();
    fun replaceWords(dictionary:List<String>,sentence:String):String{
        for(word in dictionary)insert(word);
        return sentence.split(' ').joinToString(" "){
            replace(it)
        }
    };
    private fun insert(word:String){
        var node=root;
        for(c in word){
            val index=c-'a';
            if(node.next[index]==null)node.next[index]=Node();
            node=node.next[index]!!
        };
        node.end=true
    };
    private fun replace(word:String):String{
        var node=root;
        for(i in word.indices){
            node=node.next[word[i]-'a']?:return word;
            if(node.end)return word.substring(0,i+1)
        };
        return word
    }
}
