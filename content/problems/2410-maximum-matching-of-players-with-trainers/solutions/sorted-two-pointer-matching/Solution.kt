class Solution {
    fun matchPlayersAndTrainers(players:IntArray,trainers:IntArray):Int{
        players.sort();
        trainers.sort();
        var player=0;
        var matches=0;
        for(trainer in trainers)if(player<players.size&&trainer>=players[player]){
            player++;
            matches++
        };
        return matches
    }
}
