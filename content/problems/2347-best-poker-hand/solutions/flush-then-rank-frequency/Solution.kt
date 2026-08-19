class Solution {
    fun bestHand(ranks:IntArray,suits:CharArray):String{
        if(suits.all{
            it==suits[0]
        })return "Flush";
        val frequency=IntArray(14);
        var maximum=0;
        for(rank in ranks)maximum=maxOf(maximum,++frequency[rank]);
        return when{
            maximum>=3->"Three of a Kind";
            maximum>=2->"Pair";
            else->"High Card"
        }
    }
}
