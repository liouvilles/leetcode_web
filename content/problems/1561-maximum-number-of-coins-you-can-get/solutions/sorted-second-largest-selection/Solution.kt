class Solution {
    fun maxCoins(piles:IntArray):Int{
        piles.sort();
        var answer=0;
        for(index in piles.size/3 until piles.size step 2)answer+=piles[index];
        return answer
    }
}
