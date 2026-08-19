class TopVotedCandidate(persons:IntArray,private val times:IntArray){
    private val leaders=IntArray(persons.size);
    init{
        val counts=mutableMapOf<Int,Int>();
        var leader=-1;
        var leaderVotes=0;
        for(i in persons.indices){
            val votes=(counts[persons[i]]?:0)+1;
            counts[persons[i]]=votes;
            if(votes>=leaderVotes){
                leader=persons[i];
                leaderVotes=votes
            };
            leaders[i]=leader
        }
    };
    fun q(t:Int):Int{
        var low=0;
        var high=times.size;
        while(low<high){
            val middle=low+(high-low)/2;
            if(times[middle]<=t)low=middle+1 else high=middle
        };
        return leaders[low-1]
    }
}
