class SmallestInfiniteSet {
    private var current=1;
    private val addedBack=java.util.TreeSet<Int>();
    fun popSmallest():Int{
        return if(addedBack.isEmpty())current++ else addedBack.pollFirst()
    };
    fun addBack(num:Int){
        if(num<current)addedBack.add(num)
    }
}
