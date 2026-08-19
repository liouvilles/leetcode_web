class Solution {
    fun deckRevealedIncreasing(deck:IntArray):IntArray{
        deck.sort();
        val answer=IntArray(deck.size);
        val indices=java.util.ArrayDeque<Int>();
        for(i in deck.indices)indices.addLast(i);
        for(value in deck){
            answer[indices.removeFirst()]=value;
            if(indices.isNotEmpty())indices.addLast(indices.removeFirst())
        };
        return answer
    }
}
