class Solution {
    private class TrieNode{
        val next=arrayOfNulls<TrieNode>(26)
        var owners=0
        var lastOwner=-1
    }
    fun shortestSubstrings(arr:Array<String>):Array<String>{
        val root=TrieNode()
        for(owner in arr.indices)for(start in arr[owner].indices){
            var node=root
            for(end in start until arr[owner].length){
                val letter=arr[owner][end]-'a'
                if(node.next[letter]==null)node.next[letter]=TrieNode()
                node=node.next[letter]!!
                if(node.lastOwner!=owner){node.lastOwner=owner;node.owners++}
            }
        }
        return Array(arr.size){owner->
            var best=""
            for(start in arr[owner].indices){
                var node=root
                for(end in start until arr[owner].length){
                    node=node.next[arr[owner][end]-'a']!!
                    if(node.owners==1){
                        val candidate=arr[owner].substring(start,end+1)
                        if(best.isEmpty()||candidate.length<best.length||candidate.length==best.length&&candidate<best)best=candidate
                    }
                }
            }
            best
        }
    }
}
