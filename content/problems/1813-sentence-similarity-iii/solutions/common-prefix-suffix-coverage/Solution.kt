class Solution {
    fun areSentencesSimilar(sentence1:String,sentence2:String):Boolean{
        var first=sentence1.split(' ');
        var second=sentence2.split(' ');
        if(first.size>second.size){
            val temporary=first;
            first=second;
            second=temporary
        };
        var prefix=0;
        while(prefix<first.size&&first[prefix]==second[prefix])prefix++;
        var suffix=0;
        while(prefix+suffix<first.size&&first[first.lastIndex-suffix]==second[second.lastIndex-suffix])suffix++;
        return prefix+suffix==first.size
    }
}
