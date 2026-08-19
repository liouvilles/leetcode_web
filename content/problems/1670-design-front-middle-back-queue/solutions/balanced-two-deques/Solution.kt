class FrontMiddleBackQueue {
    private val left=java.util.ArrayDeque<Int>();
    private val right=java.util.ArrayDeque<Int>();
    private fun balance(){
        if(left.size<right.size)left.addLast(right.removeFirst()) else if(left.size>right.size+1)right.addFirst(left.removeLast())
    };
    fun pushFront(value:Int){
        left.addFirst(value);
        balance()
    };
    fun pushMiddle(value:Int){
        if(left.size>right.size)right.addFirst(left.removeLast());
        left.addLast(value)
    };
    fun pushBack(value:Int){
        right.addLast(value);
        balance()
    };
    fun popFront():Int{
        if(left.isEmpty())return -1;
        val value=left.removeFirst();
        balance();
        return value
    };
    fun popMiddle():Int{
        if(left.isEmpty())return -1;
        val value=left.removeLast();
        balance();
        return value
    };
    fun popBack():Int{
        if(left.isEmpty())return -1;
        val value=if(right.isEmpty())left.removeLast() else right.removeLast();
        balance();
        return value
    }
}
