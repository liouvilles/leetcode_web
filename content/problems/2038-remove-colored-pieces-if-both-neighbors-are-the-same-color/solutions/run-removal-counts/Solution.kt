class Solution {
    fun winnerOfGame(colors:String):Boolean{
        var alice=0;
        var bob=0;
        var start=0;
        while(start<colors.length){
            var end=start;
            while(end<colors.length&&colors[end]==colors[start])end++;
            val moves=maxOf(0,end-start-2);
            if(colors[start]=='A')alice+=moves else bob+=moves;
            start=end
        };
        return alice>bob
    }
}
