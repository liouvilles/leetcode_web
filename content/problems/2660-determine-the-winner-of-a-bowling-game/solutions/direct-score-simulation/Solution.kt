class Solution {
    private fun score(player:IntArray):Int{
        var total=0;
        for(i in player.indices)total+=player[i]*(if(i>0&&player[i-1]==10||i>1&&player[i-2]==10)2 else 1);
        return total
    }
    fun isWinner(player1:IntArray,player2:IntArray):Int{
        val first=score(player1);
        val second=score(player2);
        return if(first==second)0 else if(first>second)1 else 2
    }
}
