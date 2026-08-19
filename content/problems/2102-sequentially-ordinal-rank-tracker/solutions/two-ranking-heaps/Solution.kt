class SORTracker {
    data class Place(val name:String,val score:Int);
    private val better=compareByDescending<Place>{
        it.score
    }.thenBy{
        it.name
    };
    private val worse=compareBy<Place>{
        it.score
    }.thenByDescending{
        it.name
    };
    private val selected=java.util.PriorityQueue<Place>(worse);
    private val remaining=java.util.PriorityQueue<Place>(better);
    fun add(name:String,score:Int){
        remaining.add(Place(name,score));
        if(selected.isNotEmpty()&&better.compare(remaining.peek(),selected.peek())<0){
            val best=remaining.remove();
            val worst=selected.remove();
            remaining.add(worst);
            selected.add(best)
        }
    }
    fun get():String{
        val next=remaining.remove();
        selected.add(next);
        return next.name
    }
}
