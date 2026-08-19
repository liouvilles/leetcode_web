data class MovieEntry(val price:Int,val shop:Int,val movie:Int);
class MovieRentingSystem(n:Int,entries:Array<IntArray>){
    private val order=compareBy<MovieEntry>({
        it.price
    },{
        it.shop
    },{
        it.movie
    });
    private val available=HashMap<Int,java.util.TreeSet<MovieEntry>>();
    private val rented=java.util.TreeSet<MovieEntry>(order);
    private val prices=HashMap<Long,Int>();
    private fun key(shop:Int,movie:Int)=(shop.toLong() shl 32) or (movie.toLong() and 0xffffffffL);
    private fun entry(shop:Int,movie:Int)=MovieEntry(prices[key(shop,movie)]!!,shop,movie);
    init{
        for(item in entries){
            prices[key(item[0],item[1])]=item[2];
            available.getOrPut(item[1]){
                java.util.TreeSet(order)
            }.add(MovieEntry(item[2],item[0],item[1]))
        }
    }
    fun search(movie:Int):List<Int>{
        val answer=mutableListOf<Int>();
        for(item in available[movie]?:emptySet()){
            if(answer.size==5)break;
            answer.add(item.shop)
        };
        return answer
    }
    fun rent(shop:Int,movie:Int){
        val item=entry(shop,movie);
        available[movie]!!.remove(item);
        rented.add(item)
    }
    fun drop(shop:Int,movie:Int){
        val item=entry(shop,movie);
        rented.remove(item);
        available[movie]!!.add(item)
    }
    fun report():List<List<Int>>{
        val answer=mutableListOf<List<Int>>();
        for(item in rented){
            if(answer.size==5)break;
            answer.add(listOf(item.shop,item.movie))
        };
        return answer
    }
}
