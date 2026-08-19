class Solution {
    fun stringIndices(wordsContainer:Array<String>,wordsQuery:Array<String>):IntArray{
        val total=wordsContainer.sumOf{
            it.length
        };
        val children=IntArray((total+1)*26);
        val best=IntArray(total+1){
            -1
        };
        var nodes=1;
        fun updateBest(node:Int,index:Int){
            val current=best[node];
            if(current<0||wordsContainer[index].length<wordsContainer[current].length||wordsContainer[index].length==wordsContainer[current].length&&index<current)best[node]=index
        };
        for(index in wordsContainer.indices){
            var node=0;
            updateBest(node,index);
            val word=wordsContainer[index];
            for(position in word.lastIndex downTo 0){
                val edge=node*26+(word[position]-'a');
                if(children[edge]==0)children[edge]=nodes++;
                node=children[edge];
                updateBest(node,index)
            }
        };
        return IntArray(wordsQuery.size){
            query->var node=0;
            var answer=best[0];
            val word=wordsQuery[query];
            for(position in word.lastIndex downTo 0){
                val child=children[node*26+(word[position]-'a')];
                if(child==0)break;
                node=child;
                answer=best[node]
            };
            answer
        }
    }
}
