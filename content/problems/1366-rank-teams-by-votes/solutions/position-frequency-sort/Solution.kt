class Solution {
    fun rankTeams(votes:Array<String>):String{
        val size=votes[0].length;
        val count=Array(26){
            IntArray(size)
        };
        for(vote in votes)for(i in 0 until size)count[vote[i]-'A'][i]++;
        return votes[0].toList().sortedWith(Comparator{
            a,b->for(i in 0 until size){
                val difference=count[b-'A'][i]-count[a-'A'][i];
                if(difference!=0)return@Comparator difference
            };
            a.compareTo(b)
        }).joinToString("")
    }
}
