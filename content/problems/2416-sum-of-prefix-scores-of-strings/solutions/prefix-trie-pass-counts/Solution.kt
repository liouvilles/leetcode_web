class Solution {
    private class Node{
        val children=Array<Node?>(26){
            null
        };
        var count=0
    };
    fun sumPrefixScores(words:Array<String>):IntArray{
        val root=Node();
        for(word in words){
            var node=root;
            for(ch in word){
                val index=ch-'a';
                if(node.children[index]==null)node.children[index]=Node();
                node=node.children[index]!!;
                node.count++
            }
        };
        return IntArray(words.size){
            i->var node=root;
            var score=0;
            for(ch in words[i]){
                node=node.children[ch-'a']!!;
                score+=node.count
            };
            score
        }
    }
}
