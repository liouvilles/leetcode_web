class WordDictionary {
    private class Node{
        val next=arrayOfNulls<Node>(26);
        var word=false
    };
    private val root=Node();
    fun addWord(word:String){
        var node=root;
        for(c in word){
            val i=c-'a';
            if(node.next[i]==null)node.next[i]=Node();
            node=node.next[i]!!
        };
        node.word=true
    }
    fun search(word:String):Boolean{
        fun dfs(node:Node,index:Int):Boolean{
            if(index==word.length)return node.word;
            val c=word[index];
            if(c!='.'){
                val child=node.next[c-'a']?:return false;
                return dfs(child,index+1)
            };
            return node.next.any{
                it!=null&&dfs(it,index+1)
            }
        };
        return dfs(root,0)
    }
}
